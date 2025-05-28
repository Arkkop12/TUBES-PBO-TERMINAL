package controller;

import model.*;

public class AdminController {
    private Admin admin;
    private BookingManager bookingManager;

    public AdminController(Admin admin, BookingManager bookingManager) {
        this.admin = admin;
        this.bookingManager = bookingManager;
    }

    public void viewAllBookings() {
        for (Booking booking : bookingManager.getAllBookings()) {
            System.out.println(booking);
        }
    }

    public void approveBooking(int bookingId) {
        System.out.println("Booking " + bookingId + " disetujui.");
    }

    public void rejectBooking(int bookingId) {
        System.out.println("Booking " + bookingId + " ditolak.");
    }

    public void generateDashboard() {
        System.out.println("Dashboard Statistik:");
        System.out.println("Total Booking: " + bookingManager.getAllBookings().size());
    }
}