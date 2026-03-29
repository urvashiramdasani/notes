package DesignRevenueCalculator;

public class PromotionalFare extends FareDecorator {
    public PromotionalFare(Fare fare) {
        super(fare);
    }

    @Override
    public Money getTotalFare() {
        return this.fare.getTotalFare().applyPercentageDiscount(20);
    }
}
