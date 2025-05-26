// --- File: Database.java ---
package storage;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Room> rooms = new ArrayList<>();
    public static List<Booking> bookings = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    static {
        // Tambahkan data dummy (bisa dianggap sebagai data awal di "database")
        rooms.add(new Room(1, "Lab Komputer 1", 30, "lab"));
        rooms.add(new Room(2, "Ruang Kuliah A", 40, "kuliah"));
        rooms.add(new Room(3, "Ruang Seminar", 50, "seminar"));

        users.add(new Mahasiswa(1, "Budi", "budi@example.com", "12345"));
        users.add(new Dosen(2, "Pak Andi", "andi@example.com", "12345"));
        users.add(new Admin(3, "Admin Satu", "admin@example.com", "admin"));
    }
}
