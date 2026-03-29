package DesignRevenueCalculator;

public class PromotionalFare extends FareDecorator {
    private final int promoPercent;

    public PromotionalFare(Fare fare, int promoPercent) {
        super(fare);
        this.promoPercent = promoPercent;
    }

    @Override
    public Money getTotalFare() {
        return this.fare.getTotalFare().applyPercentageDiscount(promoPercent);
    }
}
