// --- File: Booking.java ---
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
    private boolean recurring;
    private String status; // pending, approved, rejected

    public Booking(int bookingId, MahasiswaDosen user, Room room, LocalDate date,
                   LocalTime startTime, LocalTime endTime) {
        this.bookingId = bookingId;
        this.user = user;
        this.room = room;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.recurring = false;
        this.status = "pending";
    }

    public Booking(int i, String doniexamplecom, Room get, LocalDate of, LocalTime of0, LocalTime of1, String pending) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public MahasiswaDosen getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public int getBookingId() {
        return bookingId;
    }

    @Override
    public String toString() {
        return "Booking ID: " + bookingId + ", Room: " + room.getRoomName() + ", Date: " + date +
               ", Time: " + startTime + " - " + endTime + ", Status: " + status;
    }
}
