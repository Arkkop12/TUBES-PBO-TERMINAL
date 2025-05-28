package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private int bookingId;
    private UserBase user;
    private Room room;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;

    public Booking(int bookingId, UserBase user, Room room, LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.bookingId = bookingId;
        this.user = user;
        this.room = room;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getBookingId() {
        return bookingId;
    }

    public UserBase getUser() {
        return user;
    }

    public String toString() {
        return "ID: " + bookingId + ", Ruangan: " + room.getRoomName() + ", Tanggal: " + date + ", Jam: " + startTime + " - " + endTime;
    }
}
