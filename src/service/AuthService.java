package service;

import model.User;
import java.util.ArrayList;

public class AuthService {
    private ArrayList<User> users = new ArrayList<>();
    private int attempts = 0;

    public void addUser(User user) {
        users.add(user);
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.validateCredentials(username, password)) {
                attempts = 0;
                user.login();
                return user;
            }
        }
        attempts++;
        if (attempts >= 3) {
            System.out.println("Maximum login attempts reached!");
        } else {
            System.out.println("Invalid credentials!");
        }
        return null;
    }
}