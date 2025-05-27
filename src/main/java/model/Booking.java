package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private int bookingId;
    private MahasiswaDosen user;
    private Room room;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String status;

    public Booking(int bookingId, MahasiswaDosen user, Room room, LocalDate date,
                   LocalTime startTime, LocalTime endTime) {
        this.bookingId = bookingId;
        this.user = user;
        this.room = room;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = "pending";
    }

    public int getBookingId() {
        return bookingId;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public MahasiswaDosen getUser() {
        return user;
    }

    @Override
    public String toString() {
        return bookingId + " | " + room.getRoomName() + " | " + date + " " + startTime + "-" + endTime + " | Status: " + status;
    }
}
