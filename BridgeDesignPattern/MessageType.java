package BridgeDesignPattern;

public abstract class MessageType {
    Channel channel;

    public MessageType(Channel channel) {
        this.channel = channel;
    }

    public abstract void send();
}
