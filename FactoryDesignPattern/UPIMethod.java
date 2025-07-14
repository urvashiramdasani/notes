package FactoryDesignPattern;

public class UPIMethod implements PaymentMethod {
    @Override
    public void makePayment() {
        System.out.println("Paid with UPI");
    }
}
