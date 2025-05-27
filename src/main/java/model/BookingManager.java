// --- File: BookingManager.java ---
package model;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> bookingList;
    
    public BookingManager() {
        this.bookingList = new ArrayList<>();
    }

    public BookingManager(List<Booking> bookings) {
    }

    public void submitBooking(Booking booking) {
        if (!checkConflict(booking)) {
            bookingList.add(booking);
            booking.getUser().addBookingToHistory(booking);
            System.out.println("Booking berhasil diajukan.");
        } else {
            System.out.println("Booking gagal: Jadwal bentrok.");
        }
    }

    public void cancelBooking(int bookingId) {
        bookingList.removeIf(b -> b.getBookingId() == bookingId);
        System.out.println("Booking " + bookingId + " dibatalkan.");
    }

    public void updateBooking(int bookingId, Booking updatedBooking) {
        for (int i = 0; i < bookingList.size(); i++) {
            if (bookingList.get(i).getBookingId() == bookingId) {
                bookingList.set(i, updatedBooking);
                System.out.println("Booking " + bookingId + " berhasil diperbarui.");
                return;
            }
        }
        System.out.println("Booking tidak ditemukan.");
    }

    public boolean checkConflict(Booking newBooking) {
        for (Booking b : bookingList) {
            if (b.getRoom().getRoomId() == newBooking.getRoom().getRoomId() &&
                b.getDate().equals(newBooking.getDate())) {
                if (newBooking.getStartTime().isBefore(b.getEndTime()) &&
                    newBooking.getEndTime().isAfter(b.getStartTime())) {
                    return true; // Conflict
                }
            }
        }
        return false;
    }

    public void notifyUser(Booking booking, String message) {
        System.out.println("Notifikasi ke " + booking.getUser().getName() + ": " + message);
    }

    public List<Booking> getAllBookings() {
        return bookingList;
    }
}
