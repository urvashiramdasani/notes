package AdapterDesignPattern;

public class PaymentProcessorImpl implements PaymentProcessor {
    StripeSDK sdk;

    public PaymentProcessorImpl(StripeSDK sdk) {
        this.sdk = sdk;
    }

    @Override
    public void pay(int amount) {
        sdk.makePayment(amount * 30);
        System.out.println("Made payment with payment processor of amount " + amount);
    }
}
