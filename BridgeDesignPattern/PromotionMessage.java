package BridgeDesignPattern;

public class PromotionMessage extends MessageType {
    public PromotionMessage(Channel channel) {
        super(channel);
    }

    @Override
    public void send() {
        this.channel.sendMessage("Promotion");
    }
}
