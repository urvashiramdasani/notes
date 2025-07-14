package BridgeDesignPattern;

public class EmailChannel implements Channel {
    @Override
    public void sendMessage(String message) {
        System.out.println(message + " sent via email.");
    }
}
