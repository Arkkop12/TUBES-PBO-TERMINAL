package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private int bookingId;
    private User user;
    private Room room;
    private LocalDate bookingDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status;

    public Booking(int bookingId, User user, Room room, LocalDate bookingDate,
                   LocalTime startTime, LocalTime endTime, String status) {
        this.bookingId = bookingId;
        this.user = user;
        this.room = room;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public int getBookingId() { return bookingId; }
    public User getUser() { return user; }
    public Room getRoom() { return room; }
      public LocalDate getBookingDate() { return bookingDate; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public String getStatus() { return status; }
}
