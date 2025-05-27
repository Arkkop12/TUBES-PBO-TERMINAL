package Storage;

import model.Booking;
import model.MahasiswaDosen;
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

        rooms.add(new Room(12,"laboratorium pbo", 2, "Ruangan Lab"));
        rooms.add(new Room(13,"Ruang Aula", 5, "Ruangan Seminar"));
        rooms.add(new Room(15,"Ruang 101", 1, "Ruangan Kelas"));

        bookings.add(new Booking(
                1,
                new MahasiswaDosen(1,"joko","awdaw@","hahah"),
                rooms.get(0),
                LocalDate.of(2025, 6, 1),
                LocalTime.of(9, 0),
                LocalTime.of(11, 0)
        ));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
