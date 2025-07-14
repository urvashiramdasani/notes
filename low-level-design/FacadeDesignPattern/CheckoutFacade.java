package FacadeDesignPattern;

public class CheckoutFacade {
    Inventory inventory;
    Payment payment;
    Shipping shipping;

    public CheckoutFacade() {
        inventory = new Inventory();
        payment = new Payment();
        shipping = new Shipping();
    }

    public void checkout() {
        inventory.updateInventory();
        payment.makePayment();
        shipping.shipProduct();
        System.out.println("Successfully checked out!");
    }
}
