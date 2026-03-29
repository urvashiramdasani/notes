package DesignRevenueCalculator;

import java.util.HashMap;
import java.util.Map;

// can make different strategies for this, using the simplified version here.
public class PricingService {
    // for now this will return the prices based on ride type from a map
    // in real world we can query the db or apply some algorithm to return those prices.
    private static final Map<RideType, Money> rideToPriceMap = new HashMap<>();

    public PricingService() {
        rideToPriceMap.put(RideType.XL, new Money(20));
        rideToPriceMap.put(RideType.GO, new Money(15));
        rideToPriceMap.put(RideType.GO_PREMIUM, new Money(22));
        rideToPriceMap.put(RideType.AUTO, new Money(10));
        rideToPriceMap.put(RideType.BIKE, new Money(5));
    }

    public Money getBasePrice(RideType rideType) {
        return rideToPriceMap.get(rideType);
    }
}
