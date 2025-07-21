package AdapterDesignPattern;

public class Main {
    public static void main(String[] args) {
        PaymentProcessorImpl paymentProcessor = new PaymentProcessorImpl(new StripeSDK());
        paymentProcessor.pay(30);
    }
}
