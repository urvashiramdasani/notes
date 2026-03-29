package DesignRevenueCalculator;

public class SurgeFare extends FareDecorator {
    public SurgeFare(Fare fare) {
        super(fare);
    }

    @Override
    public Money getTotalFare() {
        return this.fare.getTotalFare().addMoney(new Money(5));
    }
}
