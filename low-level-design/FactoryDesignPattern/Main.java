package FactoryDesignPattern;

public class Main {
    public static void main(String[] args) {
        PaymentFactory paymentFactory = new PaymentFactory();
        PaymentMethod paymentMethod = paymentFactory.getPaymentMethod("UPI");
        paymentMethod.makePayment();

        PaymentMethod paymentMethod1 = paymentFactory.getPaymentMethod("Credit Card");
        paymentMethod1.makePayment();
    }
}
