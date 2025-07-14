package BridgeDesignPattern;

public class Main {
    public static void main(String[] args) {
        AlertMessage message = new AlertMessage(new SMSChannel());
        message.send();

        message = new AlertMessage(new EmailChannel());
        message.send();

        PromotionMessage promotionMessage = new PromotionMessage(new EmailChannel());
        promotionMessage.send();
    }
}
