package model;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookingManager {
    private List<Booking> bookings;

    public BookingManager(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void submitBooking(Booking booking) {
        bookings.add(booking);
        if (booking.getUser() instanceof UserPelanggan up) {
            up.addBookingToHistory(booking);
        }
        System.out.println("Booking berhasil diajukan.");
    }

    public void cancelBooking(int bookingId) {
    for (Booking b : bookings) {
        if (b.getBookingId() == bookingId) {
            b.setStatus("cancel");
            System.out.println("Booking ID " + bookingId + " telah dibatalkan.");
            return;
        }
    }
    System.out.println("Booking ID tidak ditemukan.");
}
    
    public void requestBooking(UserBase user, Room room, LocalDate date, LocalTime startTime, LocalTime endTime) {
    // Validasi durasi maksimal 3 jam
    long duration = java.time.Duration.between(startTime, endTime).toHours();
    if (duration > 3) {
        System.out.println("Durasi booking maksimal adalah 3 jam.");
        return;
    }

    for (Booking b : bookings) {
    // Cek user sudah booking ruangan yang sama pada tanggal yang sama
    if (b.getUser().equals(user) &&
        b.getRoom().equals(room) &&
        b.getDate().equals(date) &&
        !b.isCancelled()) {
        System.out.println("Anda sudah membooking ruangan ini pada tanggal tersebut.");
        return;
    }

    // Cek waktu bertabrakan
    if (b.getRoom().equals(room) &&
        b.getDate().equals(date) &&
        !b.isCancelled() &&
        !(endTime.isBefore(b.getStartTime()) || startTime.isAfter(b.getEndTime()))) {
        System.out.println("Waktu yang Anda pilih bertabrakan dengan booking lain.");
        System.out.println("Ruangan ini sudah dibooking dari " + b.getStartTime() + " hingga " + b.getEndTime());
        return;
    }
}
    // Buat booking baru
    Booking booking = new Booking(user, room, date, startTime, endTime);
    bookings.add(booking);

    if (user instanceof UserPelanggan up) {
        up.addBookingToHistory(booking);
    }

    System.out.println("Booking berhasil dibuat dan menunggu persetujuan.");
}

    
    public void approveBooking(int bookingId) {
    for (Booking booking : bookings) {
        if (booking.getBookingId() == bookingId && booking.getStatus().equalsIgnoreCase("pending")) {
            booking.setStatus("approved");
            notifyUser(booking, "Booking Anda telah disetujui.");
            return;
        }
    }
    System.out.println("Booking ID tidak ditemukan atau bukan status pending.");
}

    public void rejectBooking(int bookingId) {
    for (Booking booking : bookings) {
        if (booking.getBookingId() == bookingId && booking.getStatus().equalsIgnoreCase("pending")) {
            booking.setStatus("rejected");
            notifyUser(booking, "Booking Anda telah ditolak.");
            return;
        }
    }
    System.out.println("Booking ID tidak ditemukan atau bukan status pending.");
}

    public List<Booking> getAllBookings() {
        return bookings;
    }
    
    public void viewRoomSchedule(Room room, LocalDate date) {
    System.out.println("\nJadwal untuk " + room.getRoomName() + " pada " + date + ":");
    boolean found = false;
    for (Booking booking : bookings) {
        if (booking.getRoom().equals(room) && booking.getDate().equals(date)) {
            found = true;
            System.out.println(" - " + booking.getStartTime() + " s/d " + booking.getEndTime() +
                    " oleh " + booking.getUser().getUsername() +
                    " (Status: " + booking.getStatus() + ")");
        }
    }
    if (!found) {
        System.out.println("Tidak ada booking.");
    }
}

    public void notifyUser(Booking booking, String message) {
        System.out.println("Notifikasi untuk " + booking.getUser().getUsername() + ": " + message);
    }

    
}
