package model;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaDosen extends UserPelanggan {
    private List<Booking> bookingHistory = new ArrayList<>();

    public MahasiswaDosen(int id, String username, String email, String password) {
        super(id, username, email, password);
    }

    public void addBookingToHistory(Booking booking) {
        bookingHistory.add(booking);
    }

    public void viewBookingHistory() {
        System.out.println("Riwayat Booking:");
        for (Booking b : bookingHistory) {
            System.out.println(b);
        }
    }
}
