package model;

public abstract class UserPelanggan {
    protected int id;
    protected String name;
    protected String email;
    protected String role;

    public UserPelanggan(int id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public abstract void login();
    public abstract void logout();
    public abstract void requestBooking();

    public String getRole() {
        return role;
    }

    public String getName() {
        return name;
    }
}