package MediatorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Chatroom implements ChatroomInterface {
    List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for(User user : users) {
            if(user != sender) {
                user.receive(message);
            }
        }
    }
}
