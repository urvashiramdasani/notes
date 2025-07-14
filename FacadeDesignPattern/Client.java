package FacadeDesignPattern;

public class Client {
    public static void main(String[] args) {
        CheckoutFacade checkoutFacade = new CheckoutFacade();
        checkoutFacade.checkout();
    }
}
