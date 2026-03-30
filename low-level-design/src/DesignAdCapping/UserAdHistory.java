package DesignAdCapping;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/* ------------------ User-Specific History (The Core Engine) ------------------ */
class UserAdHistory {
    // Stores exact timestamps of valid impressions
    private final Deque<LocalDateTime> activeImpressions = new LinkedList<>();

    // Protects this specific user's queue from concurrent API requests
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * Records an event. If it's a click, it resets fatigue.
     * If it's an impression, it adds it to the queue.
     */
    public void recordEvent(AdEvent event, Duration rollingWindow) {
        lock.lock();
        try {
            if (event.type == AdEventType.CLICK) {
                // THE ENGAGEMENT RULE: A click proves interest. Wipe the fatigue slate clean!
                activeImpressions.clear();
            } else if (event.type == AdEventType.IMPRESSION) {
                activeImpressions.addLast(event.timestamp);
            }

            // Clean up memory by removing old events
            evictOldImpressions(event.timestamp, rollingWindow);
        } finally {
            lock.unlock();
        }
    }

    /**
     * Slides the window forward to the current time, evicts old data,
     * and checks if the remaining count hits the limit.
     */
    public boolean isCapped(LocalDateTime now, Duration rollingWindow, int threshold) {
        lock.lock();
        try {
            evictOldImpressions(now, rollingWindow);
            return activeImpressions.size() >= threshold;
        } finally {
            lock.unlock();
        }
    }

    /**
     * The True Sliding Window logic. Amortized O(1) time complexity.
     */
    private void evictOldImpressions(LocalDateTime currentTime, Duration rollingWindow) {
        LocalDateTime cutoffTime = currentTime.minus(rollingWindow);

        // Remove timestamps from the front of the queue if they are older than the cutoff
        while (!activeImpressions.isEmpty() && activeImpressions.peekFirst().isBefore(cutoffTime)) {
            activeImpressions.pollFirst();
        }
    }

    // For debugging/printing
    public int getActiveCount() {
        return activeImpressions.size();
    }
}
