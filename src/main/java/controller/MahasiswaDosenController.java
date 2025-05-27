package controller;

import model.Booking;
import model.BookingManager;
import model.MahasiswaDosen;
import model.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MahasiswaDosenController {
    private MahasiswaDosen user;
    private BookingManager bookingManager;

    public MahasiswaDosenController(MahasiswaDosen user, BookingManager bookingManager) {
        this.user = user;
        this.bookingManager = bookingManager;
    }

    public void checkAvailability(List<Room> roomList) {
        for (Room r : roomList) {
            System.out.println(r.getRoomName() + " tersedia: " + r.isAvailable());
        }
    }

    public void viewBookingHistory() {
        user.viewBookingHistory();
    }

    public void requestBooking(Room room, LocalDate date, LocalTime start, LocalTime end) {
        Booking newBooking = new Booking(
            bookingManager.getAllBookings().size() + 1,
            user, room, date, start, end
        );
        bookingManager.submitBooking(newBooking);
    }
}
