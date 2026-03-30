package DesignAdCapping;

import java.time.LocalDateTime;

class AdEvent {
    public final String userId;
    public final String adId;
    public final LocalDateTime timestamp;
    public final AdEventType type;

    public AdEvent(String userId, String adId, LocalDateTime timestamp, AdEventType type) {
        this.userId = userId;
        this.adId = adId;
        this.timestamp = timestamp;
        this.type = type;
    }
}
