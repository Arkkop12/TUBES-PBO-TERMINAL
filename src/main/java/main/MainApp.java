package main;

import controller.*;
import model.*;
import Storage.Database;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService();
        Database database = new Database();
        BookingManager bookingManager = new BookingManager(database.getBookings());
        List<Room> rooms = database.getRooms();

        System.out.println("=== Selamat Datang di Sistem Reservasi Ruangan ===");
        System.out.print("Masukkan email untuk login: ");
        String email = scanner.nextLine();

        Object user = loginService.login(email);
        switch (user) {
            case null -> {
                System.out.println("Login gagal: Email tidak ditemukan.");
                return;
            }
            case Admin admin -> {
                AdminController controller = new AdminController(admin, bookingManager);
                admin.login();
                int choice;
                do {
                    System.out.println("\n[ADMIN MENU]");
                    System.out.println("1. Lihat Semua Booking");
                    System.out.println("2. Setujui Booking");
                    System.out.println("3. Tolak Booking");
                    System.out.println("4. Dashboard");
                    System.out.println("0. Keluar");
                    System.out.print("Pilih menu: ");
                    choice = scanner.nextInt();
                    
                    switch (choice) {
                        case 1 -> controller.viewAllBookings();
                        case 2 -> {
                            System.out.print("Masukkan ID Booking: ");
                            int id = scanner.nextInt();
                            controller.approveBooking(id);
                        }
                        case 3 -> {
                            System.out.print("Masukkan ID Booking: ");
                            int id = scanner.nextInt();
                            controller.rejectBooking(id);
                        }
                        case 4 -> controller.generateDashboard();
                        case 0 -> admin.logout();
                        default -> System.out.println("Menu tidak tersedia.");
                    }
                } while (choice != 0);
            }
            case MahasiswaDosen md -> {
                MahasiswaDosenController controller = new MahasiswaDosenController(md, bookingManager);
                md.login();
                int choice;
                do {
                    System.out.println("\n[" + md.getRole().toUpperCase() + " MENU]");
                    System.out.println("1. Lihat Riwayat Booking");
                    System.out.println("2. Cek Ketersediaan Ruangan");
                    System.out.println("3. Request Booking");
                    System.out.println("0. Keluar");
                    System.out.print("Pilih menu: ");
                    choice = scanner.nextInt();
                    
                    switch (choice) {
                        case 1 -> controller.viewBookingHistory();
                        case 2 -> controller.checkAvailability(rooms);
                        case 3 -> {
                            scanner.nextLine(); // buffer clear
                            System.out.print("Masukkan nama ruangan: ");
                            String roomName = scanner.nextLine();
                            Room selectedRoom = null;
                            for (Room r : rooms) {
                                if (r.getRoomName().equalsIgnoreCase(roomName)) {
                                    selectedRoom = r;
                                    break;
                                }
                            }
                            
                            if (selectedRoom == null) {
                                System.out.println("Ruangan tidak ditemukan.");
                                break;
                            }
                            
                            System.out.print("Tanggal (yyyy-mm-dd): ");
                            String dateStr = scanner.nextLine();
                            System.out.print("Waktu mulai (hh:mm): ");
                            String startStr = scanner.nextLine();
                            System.out.print("Waktu selesai (hh:mm): ");
                            String endStr = scanner.nextLine();
                            
                            LocalDate date = LocalDate.parse(dateStr);
                            LocalTime start = LocalTime.parse(startStr);
                            LocalTime end = LocalTime.parse(endStr);
                            
                            controller.requestBooking(selectedRoom, date, start, end);
                        }
                        case 0 -> md.logout();
                        default -> System.out.println("Menu tidak tersedia.");
                    }
                } while (choice != 0);
            }
            default -> System.out.println("Tipe user tidak dikenali.");
        }
    }
}
