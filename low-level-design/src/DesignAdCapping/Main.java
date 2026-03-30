package DesignAdCapping;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Rule: Max 3 impressions per rolling 24 hours
        AdCappingService adEngine = new AdCappingService(Duration.ofHours(24), 3);

        String user1 = "user_123";
        String user2 = "user_999";
        String promoAd = "ad_promo_spring";

        LocalDateTime now = LocalDateTime.now();

        System.out.println("--- Processing Historical Events ---");
        List<AdEvent> logs = Arrays.asList(
                // User 1 sees the ad 3 times yesterday.
                new AdEvent(user1, promoAd, now.minusHours(26), AdEventType.IMPRESSION), // Outside 24h window
                new AdEvent(user1, promoAd, now.minusHours(20), AdEventType.IMPRESSION), // Inside window
                new AdEvent(user1, promoAd, now.minusHours(10), AdEventType.IMPRESSION), // Inside window

                // User 2 sees it 3 times, but clicks on the 4th time!
                new AdEvent(user2, promoAd, now.minusHours(15), AdEventType.IMPRESSION),
                new AdEvent(user2, promoAd, now.minusHours(10), AdEventType.IMPRESSION),
                new AdEvent(user2, promoAd, now.minusHours(5),  AdEventType.IMPRESSION),
                new AdEvent(user2, promoAd, now.minusHours(2),  AdEventType.CLICK) // Resets fatigue!
        );

        adEngine.processEvents(logs);

        System.out.println("\n--- Real-Time Ad Requests (Time: NOW) ---");

        // USER 1 CHECK:
        // Had 3 impressions, but one was 26 hours ago (evicted). Remaining active: 2.
        // Threshold is 3. Should NOT be capped.
        boolean user1Capped = adEngine.shouldBlockAd(user1, promoAd, now);
        System.out.println("Is User 1 Capped? " + user1Capped); // Expected: false

        // Let's show the ad to User 1 again right now
        adEngine.processEvents(Arrays.asList(new AdEvent(user1, promoAd, now, AdEventType.IMPRESSION)));

        // Check User 1 again immediately
        boolean user1CappedAgain = adEngine.shouldBlockAd(user1, promoAd, now.plusSeconds(1));
        System.out.println("Is User 1 Capped after showing another ad? " + user1CappedAgain); // Expected: true

        // USER 2 CHECK:
        // Had 3 impressions, which would normally cap them.
        // BUT they clicked 2 hours ago. Should NOT be capped.
        boolean user2Capped = adEngine.shouldBlockAd(user2, promoAd, now);
        System.out.println("Is User 2 Capped (they clicked earlier)? " + user2Capped); // Expected: false
    }
}
