package Storage;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<UserBase> users = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public Database() {
        // Tambahkan beberapa User
        users.add(new Admin(1, "admin1", "admin@gmail.com", "admin123"));
        users.add(new MahasiswaDosen(2, "Arka", "arkkop@gmail.com", "123"));
        users.add(new MahasiswaDosen(3, "Nira", "nira@gmail.com", "123"));
        users.add(new MahasiswaDosen(4, "khansa", "sasa@gmail.com", "123"));
        users.add(new MahasiswaDosen(5, "henri", "sadler@gmail.com", "123"));

        // Tambahkan beberapa Room
        rooms.add(new Room(1, "Ruang Kelas 1"));
        rooms.add(new Room(2, "Lab Komputer 1"));
        rooms.add(new Room(3, "Lab Fisika"));
        rooms.add(new Room(4, "Ruang Rapat"));

        // Tidak perlu isi booking awal, akan diisi saat runtime
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
