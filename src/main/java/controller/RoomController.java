package controller;

import model.BookingManager;
import model.Room;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RoomController {

    public static void lihatRuanganDanJadwal(List<Room> rooms, BookingManager bookingManager, Scanner scanner) {
        System.out.println("\nDaftar Ruangan:");
        for (Room r : rooms) {
            System.out.println("ID " + r.getRoomId() + " - " + r.getRoomName());
        }

        System.out.print("Masukkan ID ruangan untuk melihat jadwal: ");
        int selectedId = scanner.nextInt();
        scanner.nextLine(); // Buang newline

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomId() == selectedId) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("ID ruangan tidak ditemukan.");
            return;
        }

        System.out.print("Masukkan tanggal yang ingin dilihat (YYYY-MM-DD): ");
        String tanggalInput = scanner.nextLine();
        LocalDate tanggal;
        try {
            tanggal = LocalDate.parse(tanggalInput);
        } catch (Exception e) {
            System.out.println("Format tanggal salah.");
            return;
        }

        bookingManager.viewRoomSchedule(selectedRoom, tanggal);
    }
}
