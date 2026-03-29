package DesignRevenueCalculator;

public class RideBillingSystem {
    private final CustomerRevenueTracker revenueTracker;

    public RideBillingSystem(CustomerRevenueTracker revenueTracker) {
        this.revenueTracker = revenueTracker;
    }

    /**
     * This method bridges the Object-Oriented Pricing Engine
     * with the Algorithmic Data Tracker.
     */
    public void processCompletedRide(String customerId, RideDetails details, boolean isSurge, int promoPercent) {

        // 1. Start the Pricing Pipeline (LLD)
        Fare finalFare = new BaseRideFare(details);

        if (isSurge) {
            finalFare = new SurgeFare(finalFare); // Add flat surge
        }

        if (promoPercent > 0) {
            finalFare = new PromotionalFare(finalFare, promoPercent); // Apply % discount
        }

        // 2. Execute the calculation safely
        Money amountToCharge = finalFare.getTotalFare();
        System.out.println("Charging Customer " + customerId + ": " + amountToCharge.toString());

        // 3. Feed the result into the Analytics Database (DSA)
        revenueTracker.addRevenue(customerId, amountToCharge);

        // Handle referral logic if this ride had a referrer (omitted for brevity,
        // but you would just call revenueTracker.addRevenue(referrerId, referralBonus))
    }
}
