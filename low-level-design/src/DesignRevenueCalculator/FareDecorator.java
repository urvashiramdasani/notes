package DesignRevenueCalculator;

public abstract class FareDecorator implements Fare {
    protected Fare fare;

    public FareDecorator(Fare fare) {
        this.fare = fare;
    }
}
