package MediatorDesignPattern;

public class User {
    String name;
    ChatroomInterface chatroomInterface;

    public User(String name, ChatroomInterface chatroomInterface) {
        this.name = name;
        this.chatroomInterface = chatroomInterface;
    }

    public void send(String message) {
        System.out.println(this.name + " has sent the message: " + message);
        chatroomInterface.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println(this.name + " received the message " + message);
    }
}
