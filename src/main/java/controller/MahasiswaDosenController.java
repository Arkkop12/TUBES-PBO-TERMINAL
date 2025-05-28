// File: controller/MahasiswaDosenController.java
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
    System.out.println("=== Riwayat Booking Anda ===");
    boolean found = false;
    for (Booking b : bookingManager.getAllBookings()) {
        if (b.getUser().equals(user)) {
            found = true;
            String status;
            if (b.isCancelled()) {
                status = "Cancelled";
            } else if (b.isApproved()) {
                status = "Approved";
            } else if (b.isRejected()) {
                status = "Rejected";
            } else {
                status = "Pending";
            }

            System.out.printf(
                "ID: %d | User: %s | Ruangan: %s | Tanggal: %s | %s - %s | Status: %s%n",
                b.getBookingId(),
                b.getUser(),
                b.getRoom(),
                b.getDate(),
                b.getStartTime(),
                b.getEndTime(),
                status
            );
        }
    }

    if (!found) {
        System.out.println("Belum ada riwayat booking.");
    }
}

    public void requestBooking(Room room, LocalDate date, LocalTime start, LocalTime end) {
        int bookingId = bookingManager.getAllBookings().size() + 1;
        Booking booking = new Booking(bookingId, user, room, date, start, end);
        bookingManager.submitBooking(booking);
    }

    public void cancelBooking(int bookingId) {
        boolean owned = bookingManager.getAllBookings().stream()
            .anyMatch(b -> b.getBookingId() == bookingId && b.getUser().equals(user));
        if (owned) {
            bookingManager.cancelBooking(bookingId);
        } else {
            System.out.println("Anda tidak memiliki booking dengan ID tersebut.");
        }
    }
}
