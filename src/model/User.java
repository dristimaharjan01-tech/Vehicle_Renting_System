package model;

import java.time.LocalDateTime;

public class User {
    protected String userId;
    protected String username;
    protected String password;
    protected String role;
    protected LocalDateTime lastLogin;

    public User(String userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = encryptPassword(password);
        this.role = role;
    }

    public boolean validateCredentials(String username, String password) {
        return this.username.equals(username) && this.password.equals(encryptPassword(password));
    }

    public String encryptPassword(String password) {
        return Integer.toHexString(password.hashCode()); // simple encryption
    }

    public void login() {
        lastLogin = LocalDateTime.now();
        System.out.println(role + " logged in at " + lastLogin);
    }

    public void logout() {
        System.out.println(username + " logged out.");
    }

    public String getRole() {
        return role;
    }
}