package model;

public abstract class UserAdmin extends UserBase {
    public UserAdmin(int id, String username, String email, String password) {
        super(id, username, email, password);
    }
}