package controller;

import model.BookingManager;

public class BookingController {
    private BookingManager bookingManager;

    public BookingController(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public void cancelBooking(int bookingId) {
        bookingManager.cancelBooking(bookingId);
    }

    public void updateBooking(int bookingId) {
        // Dummy contoh, biasanya menerima booking baru
        System.out.println("Update booking belum diimplementasikan.");
    }
}
