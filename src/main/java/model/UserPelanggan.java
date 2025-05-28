package model;

public abstract class UserPelanggan extends UserBase {
    public UserPelanggan(int id, String username, String email, String password) {
        super(id, username, email, password);
    }

    public abstract void addBookingToHistory(Booking booking);
}