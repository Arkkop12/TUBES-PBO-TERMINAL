package Storage;

import model.Booking;
import model.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Room> rooms;
    private List<Booking> bookings;

    public Database() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();

        // Data dummy ruangan
        rooms.add(new Room("Lab A", "Lab Komputer", 30));
        rooms.add(new Room("Lab B", "Lab Jaringan", 25));
        rooms.add(new Room("Ruang 101", "Ruang Kelas", 40));

        // Data dummy booking
        bookings.add(new Booking(
            1,
            "doni@example.com",
            rooms.get(0),
            LocalDate.of(2025, 6, 1),
            LocalTime.of(9, 0),
            LocalTime.of(11, 0),
            "pending"
        ));
        bookings.add(new Booking(
            2,
            "dedi@example.com",
            rooms.get(1),
            LocalDate.of(2025, 6, 2),
            LocalTime.of(13, 0),
            LocalTime.of(15, 0),
            "approved"
        ));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
}
