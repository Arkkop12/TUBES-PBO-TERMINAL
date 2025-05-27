package model;

import java.util.List;

public class BookingManager {
    private List<Booking> bookings;

    public BookingManager(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void submitBooking(Booking booking) {
        bookings.add(booking);
        booking.getUser().addBookingToHistory(booking);
        System.out.println("Booking berhasil diajukan.");
    }

    public void cancelBooking(int bookingId) {
        bookings.removeIf(b -> b.getBookingId() == bookingId);
        System.out.println("Booking berhasil dibatalkan.");
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public void notifyUser(Booking booking, String message) {
        System.out.println("Notifikasi untuk " + booking.getUser().username + ": " + message);
    }
}
