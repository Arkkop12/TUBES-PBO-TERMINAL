package service;

import model.Admin;
import model.MahasiswaDosen;

public class LoginService {
    public Object login(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            return new Admin(0, "admin", "admin@example.com", "admin123");
        } else if (username.equals("joko") && password.equals("hahah")) {
            return new MahasiswaDosen(1, "joko", "awdaw@", "hahah");
        } else {
            return null;
        }
    }
}
