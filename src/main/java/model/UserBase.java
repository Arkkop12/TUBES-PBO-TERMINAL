package model;

import java.util.Objects;

public abstract class UserBase {
    public int id;
    public String username;
    public String email;
    public String password;

    public UserBase(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
    return username;
    }

}
