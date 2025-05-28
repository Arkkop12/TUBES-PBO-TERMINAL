package model;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

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
    
    public void requestBooking(UserBase user, Room room, LocalDate date, LocalTime startTime, LocalTime endTime) {
        int bookingId = bookings.size() + 1; // Generate ID sederhana
        Booking booking = new Booking(bookingId, user, room, date, startTime, endTime);
        bookings.add(booking);

    // Tambahkan ke histori jika user adalah pelanggan
    if (user instanceof UserPelanggan up) {
        up.addBookingToHistory(booking);
    }

    System.out.println("Booking berhasil dibuat dan menunggu persetujuan.");
}
    
    public void approveBooking(int bookingId) {
    for (Booking booking : bookings) {
        if (booking.getBookingId() == bookingId && booking.getStatus().equalsIgnoreCase("pending")) {
            booking.setStatus("approved");
            notifyUser(booking, "Booking Anda telah disetujui.");
            return;
        }
    }
    System.out.println("Booking ID tidak ditemukan atau bukan status pending.");
}

    public void rejectBooking(int bookingId) {
    for (Booking booking : bookings) {
        if (booking.getBookingId() == bookingId && booking.getStatus().equalsIgnoreCase("pending")) {
            booking.setStatus("rejected");
            notifyUser(booking, "Booking Anda telah ditolak.");
            return;
        }
    }
    System.out.println("Booking ID tidak ditemukan atau bukan status pending.");
}

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public void notifyUser(Booking booking, String message) {
        System.out.println("Notifikasi untuk " + booking.getUser().getUsername() + ": " + message);
    }

    
}
