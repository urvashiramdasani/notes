package DesignRevenueCalculator;

public class Money {
    private final long cents;

    public Money(long cents) {
        this.cents = cents;
    }

    public Money addMoney(Money money) {
        return new Money(money.cents + this.cents);
    }

    public Money subtractMoney(Money money) {
        long newCents = this.cents - money.cents;
        return new Money(Math.max(0, newCents));
    }

    public Money applyPercentageDiscount(int discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Invalid discount percentage");
        }
        long discountAmount = (this.cents * discountPercentage) / 100;
        return new Money(this.cents - discountAmount);
    }

    public long getCents() {
        return this.cents;
    }
}
