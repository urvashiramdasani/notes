package DesignAdCapping;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class AdCappingService {

    private final Duration rollingWindow;
    private final int impressionThreshold;

    // The Global In-Memory Database
    // Key format: "{userId}:{adId}"
    private final ConcurrentHashMap<String, UserAdHistory> cache = new ConcurrentHashMap<>();

    public AdCappingService(Duration rollingWindow, int impressionThreshold) {
        this.rollingWindow = rollingWindow;
        this.impressionThreshold = impressionThreshold;
    }

    private String generateCompositeKey(String userId, String adId) {
        return userId + ":" + adId;
    }

    public void processEvents(List<AdEvent> events) {
        for (AdEvent event : events) {
            String cacheKey = generateCompositeKey(event.userId, event.adId);

            // computeIfAbsent is atomic and thread-safe!
            UserAdHistory history = cache.computeIfAbsent(cacheKey, k -> new UserAdHistory());
            history.recordEvent(event, rollingWindow);
        }
    }

    public boolean shouldBlockAd(String userId, String adId, LocalDateTime requestTime) {
        String cacheKey = generateCompositeKey(userId, adId);
        UserAdHistory history = cache.get(cacheKey);

        // If no history exists, they are definitely not capped
        if (history == null) {
            return false;
        }

        return history.isCapped(requestTime, rollingWindow, impressionThreshold);
    }
}