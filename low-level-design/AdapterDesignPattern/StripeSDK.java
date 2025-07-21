package AdapterDesignPattern;

public class StripeSDK {
    public void makePayment(int valueInCents) {
        System.out.println("Made payment via Stripe SDK for the amount " + valueInCents);
    }
}
