package controller;

import model.*;

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

    public void checkAvailability(List<Room> rooms) {
        System.out.println("Daftar Ruangan:");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public void viewBookingHistory() {
        user.viewBookingHistory();
    }

    public void requestBooking(Room room, LocalDate date, LocalTime start, LocalTime end) {
        int bookingId = bookingManager.getAllBookings().size() + 1;
        Booking booking = new Booking(bookingId, user, room, date, start, end);
        bookingManager.submitBooking(booking);
    }
}
