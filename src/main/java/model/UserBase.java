package model;

public abstract class UserBase {
    protected int id;
    protected String username;
    protected String email;
    protected String password;

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
}