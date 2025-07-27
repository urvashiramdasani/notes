package MediatorDesignPattern;

public interface ChatroomInterface {
    void addUser(User user);
    void sendMessage(String message, User sender);
}
