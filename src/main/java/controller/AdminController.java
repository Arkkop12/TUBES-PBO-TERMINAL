package controller;

import model.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AdminController {
    private Admin admin;
    private BookingManager bookingManager;

    public AdminController(Admin admin, BookingManager bookingManager) {
        this.admin = admin;
        this.bookingManager = bookingManager;
    }

    public void viewAllBookings() {
        List<Booking> bookings = bookingManager.getAllBookings();
        if (bookings.isEmpty()) {
            System.out.println("Belum ada booking.");
        } else {
            System.out.println("\n=== Daftar Semua Booking ===");
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    public void approveBooking(int bookingId) {
        bookingManager.approveBooking(bookingId);
    }

    public void rejectBooking(int bookingId) {
        bookingManager.rejectBooking(bookingId);
    }

    public void generateDashboard() {
        long total = bookingManager.getAllBookings().size();
        long approved = bookingManager.getAllBookings().stream().filter(Booking::isApproved).count();
        long pending = bookingManager.getAllBookings().stream().filter(Booking::isPending).count();
        long rejected = bookingManager.getAllBookings().stream().filter(Booking::isRejected).count();
        long canceled = bookingManager.getAllBookings().stream().filter(Booking::isCancelled).count();

        System.out.println("\n=== Dashboard Statistik ===");
        System.out.println("Total Booking: " + total);
        System.out.println("Disetujui: " + approved);
        System.out.println("Pending: " + pending);
        System.out.println("Ditolak: " + rejected);
        System.out.println("Dibatalkan: " + canceled);
    }
    
    public void viewRooms(List<Room> rooms) {
    System.out.println("\n=== Daftar Ruangan ===");
    for (Room room : rooms) {
        System.out.println(room);
    }
}


    public void requestBooking(Room room, LocalDate date, LocalTime start, LocalTime end) {
        bookingManager.requestBooking(admin, room, date, start, end);
    }
}
