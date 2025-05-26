package model;

import java.time.LocalDate;

public class RecurringBooking {
    private int id;
    private Booking booking;
    private LocalDate recurringDate;

    public RecurringBooking(int id, Booking booking, LocalDate recurringDate) {
        this.id = id;
        this.booking = booking;
        this.recurringDate = recurringDate;
    }

    public int getId() { return id; }
    public Booking getBooking() { return booking; }
    public LocalDate getRecurringDate() { return recurringDate; }
}