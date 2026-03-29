package DesignRevenueCalculator;

public class BaseRideFare implements Fare {
    private final RideDetails rideDetails;
    private final PricingService pricingService;

    public BaseRideFare(RideDetails rideDetails) {
        this.rideDetails = rideDetails;
        this.pricingService = new PricingService();
    }

    // this can be extended to calculate fare based on distance travelled,
    // for this we can also use some other pricing strategy or a different method from same service
    @Override
    public Money getTotalFare() {
        return pricingService.getBasePrice(rideDetails.getRideType());
    }
}
