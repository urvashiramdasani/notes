package FactoryDesignPattern;

public class CreditCardMethod implements PaymentMethod {
    @Override
    public void makePayment() {
        System.out.println("Paid with Credit Card");
    }
}
