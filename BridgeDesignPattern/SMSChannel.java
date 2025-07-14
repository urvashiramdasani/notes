package BridgeDesignPattern;

public class SMSChannel implements Channel {

    @Override
    public void sendMessage(String message) {
        System.out.println(message + " sent via SMS.");
    }
}
