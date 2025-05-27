package controller;

import model.Admin;
import model.Booking;
import model.BookingManager;

public class AdminController {
    private Admin admin;
    private BookingManager bookingManager;

    public AdminController(Admin admin, BookingManager bookingManager) {
        this.admin = admin;
        this.bookingManager = bookingManager;
    }

    public void viewAllBookings() {
        System.out.println("--- Semua Booking ---");
        for (Booking b : bookingManager.getAllBookings()) {
            System.out.println(b);
        }
    }

    public void approveBooking(int bookingId) {
        for (Booking b : bookingManager.getAllBookings()) {
            if (b.getBookingId() == bookingId) {
                b.updateStatus("approved");
                bookingManager.notifyUser(b, "Booking Anda telah disetujui.");
                return;
            }
        }
        System.out.println("Booking ID tidak ditemukan.");
    }

    public void rejectBooking(int bookingId) {
        for (Booking b : bookingManager.getAllBookings()) {
            if (b.getBookingId() == bookingId) {
                b.updateStatus("rejected");
                bookingManager.notifyUser(b, "Booking Anda ditolak.");
                return;
            }
        }
        System.out.println("Booking ID tidak ditemukan.");
    }

    public void generateDashboard() {
        System.out.println("Dashboard: Total Booking = " + bookingManager.getAllBookings().size());
    }
}
