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
    private String status = "pending"; 


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

    public void setStatus(String status) {
    this.status = status;
}
  
    public boolean isApproved() {
    return "approved".equalsIgnoreCase(status);
}

    public boolean isRejected() {
    return "rejected".equalsIgnoreCase(status);
}

    public boolean isCancelled() {
    return "cancel".equalsIgnoreCase(status);
}
    
    public boolean isPending() {
    return "pending".equalsIgnoreCase(status);
}

    public String toString() {
        return "ID: " + bookingId + ", Ruangan: " + room.getRoomName() + ", Tanggal: " + date + ", Jam: " + startTime + " - " + endTime;
    }
}