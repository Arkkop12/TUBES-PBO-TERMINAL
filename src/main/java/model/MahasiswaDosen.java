package model;

import java.util.List;

public class MahasiswaDosen extends UserPelanggan {
    private List<Booking> bookingHistory;

    public MahasiswaDosen(int id, String name, String email, String role) {
        super(id, name, email, role);
    }

    @Override
    public void login() {
        System.out.println(role + " login: " + name);
    }

    @Override
    public void logout() {
        System.out.println(role + " logout.");
    }

    @Override
    public void requestBooking() {
        System.out.println(role + " membuat booking.");
    }

    public void viewBookingHistory() {
        System.out.println("Riwayat booking untuk " + name + ":");
        if (bookingHistory == null || bookingHistory.isEmpty()) {
            System.out.println("Belum ada booking.");
        } else {
            for (Booking b : bookingHistory) {
                System.out.println("- " + b);
            }
        }
    }

    public void checkAvailability() {
        System.out.println("Cek ketersediaan ruangan.");
    }

    public void addBookingToHistory(Booking booking) {
        bookingHistory.add(booking);
    }
}
