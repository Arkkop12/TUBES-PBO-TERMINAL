package model;

public abstract class UserAdmin {
    protected int id;
    protected String username;
    protected String email;
    protected String password;

    public UserAdmin(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // getter dan setter
}
