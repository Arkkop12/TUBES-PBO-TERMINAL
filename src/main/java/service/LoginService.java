package service;

import model.*;
import Storage.Database;

public class LoginService {
    private Database db = new Database();

    public UserBase login(String email, String password) {
        for (UserBase user : db.getAllUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}