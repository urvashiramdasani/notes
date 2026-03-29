package DesignRevenueCalculator;

public class BaseRideFare implements Fare {
    @Override
    public Money getTotalFare() {
        return new Money(20);
    }
}
