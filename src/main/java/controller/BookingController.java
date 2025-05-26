// --- File: BookingController.java ---
package controller;

import model.*;
import storage.Database;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class BookingController {
    private int bookingCounter = Database.bookings.size() + 1;

    public void listRooms() {
        for (Room room : Database.rooms) {
            System.out.println(room.getRoomId() + ". " + room.getRoomName() + " (" + room.getType() + ")");
        }
    }

    public void bookRoom(User user, Scanner scanner) {
        listRooms();
        System.out.print("Pilih ID ruangan: ");
        int roomId = scanner.nextInt();
        scanner.nextLine();

        Room selectedRoom = null;
        for (Room room : Database.rooms) {
            if (room.getRoomId() == roomId) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Ruangan tidak ditemukan.");
            return;
        }

        System.out.print("Tanggal Booking (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.print("Waktu Mulai (HH:mm): ");
        LocalTime start = LocalTime.parse(scanner.nextLine());
        System.out.print("Waktu Selesai (HH:mm): ");
        LocalTime end = LocalTime.parse(scanner.nextLine());

        Booking newBooking = new Booking(bookingCounter++, user, selectedRoom, date, start, end, "pending");
        Database.bookings.add(newBooking);

        System.out.println("Booking berhasil dibuat dengan status 'pending'.");
    }

    public void listBookings() {
        for (Booking b : Database.bookings) {
            System.out.println("Booking ID: " + b.getBookingId()
                    + ", Ruangan: " + b.getRoom().getRoomName()
                    + ", Tanggal: " + b.getBookingDate()
                    + ", Status: " + b.getStatus());
        }
    }
}
