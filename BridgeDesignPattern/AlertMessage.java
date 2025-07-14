package BridgeDesignPattern;

public class AlertMessage extends MessageType {

    public AlertMessage(Channel channel) {
        super(channel);
    }

    @Override
    public void send() {
        this.channel.sendMessage("Alert");
    }
}
