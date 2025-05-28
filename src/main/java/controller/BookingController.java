package controller;

import model.BookingManager;
import model.UserBase;

public class BookingController {
    private BookingManager bookingManager;

    public BookingController(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }
    
    public void updateBooking(int bookingId) {
        System.out.println("Update booking belum diimplementasikan.");
    }
}
