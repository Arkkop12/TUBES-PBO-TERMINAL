package model;

import java.util.Iterator;
import java.util.List;

public class BookingManager {
    private List<Booking> bookings;

    public BookingManager(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void submitBooking(Booking booking) {
        bookings.add(booking);
        if (booking.getUser() instanceof UserPelanggan up) {
            up.addBookingToHistory(booking);
        }
        System.out.println("Booking berhasil diajukan.");
    }

    public void cancelBooking(int bookingId) {
    for (Booking b : bookings) {
        if (b.getBookingId() == bookingId) {
            b.setStatus("cancel");
            System.out.println("Booking ID " + bookingId + " telah dibatalkan.");
            return;
        }
    }
    System.out.println("Booking ID tidak ditemukan.");
}

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public void notifyUser(Booking booking, String message) {
        System.out.println("Notifikasi untuk " + booking.getUser().getUsername() + ": " + message);
    }
}
