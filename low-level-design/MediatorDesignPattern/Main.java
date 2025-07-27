package MediatorDesignPattern;

public class Main {
    public static void main(String[] args) {
        Chatroom chatroom = new Chatroom();
        User user1 = new User("user1", chatroom);
        User user2 = new User("user2", chatroom);
        User user3 = new User("user3", chatroom);

        chatroom.addUser(user1);
        chatroom.addUser(user2);
        chatroom.addUser(user3);

        user1.send("hi");
        user2.send("hello...");
    }
}
