package Storage;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<UserBase> users = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public Database() {
        users.add(new MahasiswaDosen(1, "Budi", "budi@email.com", "1234"));
        users.add(new Admin(2, "Admin", "admin@email.com", "admin"));
        rooms.add(new Room(1, "Ruang Kelas A"));
        rooms.add(new Room(2, "Laboratorium B"));
    }

    public List<UserBase> getAllUsers() {
        return users;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
