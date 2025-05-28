package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Admin extends UserAdmin {
    public Admin(int id, String username, String email, String password) {
        super(id, username, email, password);
    }

    public void requestBooking(Room room, LocalDate date, LocalTime startTime, LocalTime endTime) {
        System.out.println("Admin melakukan permintaan booking (dummy).");
    }
}