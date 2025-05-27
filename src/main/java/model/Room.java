package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Room {
    private int roomId;
    private String roomName;
    private int capacity;
    private String type;

    public Room(int roomId, String roomName, int capacity, String type) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.type = type;
    }

    public Room(String lab_A, String lab_Komputer, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    // ✅ Method untuk cek apakah ruangan tersedia pada waktu tertentu
    public boolean isAvailable(LocalDate date, LocalTime start, LocalTime end, List<Booking> bookings) {
        for (Booking booking : bookings) {
            if (booking.getRoom().getRoomId() == this.roomId &&
                booking.getDate().equals(date) &&
                (start.isBefore(booking.getEndTime()) && end.isAfter(booking.getStartTime()))) {
                return false; // ada konflik waktu
            }
        }
        return true; // tidak ada konflik
    }

    public String isAvailable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
