package main;

import model.*;
import service.LoginService;
import Storage.Database;
import controller.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService();
        Database db = new Database();
        BookingManager bookingManager = new BookingManager(db.getBookings());

        System.out.println("Selamat datang di Sistem Reservasi Ruangan");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        UserBase user = loginService.login(email, password);

        if (user == null) {
            System.out.println("Login gagal. Email atau password salah.");
            return;
        }

        System.out.println("\nLogin berhasil. Selamat datang, " + user.username + "!\n");

        if (user instanceof MahasiswaDosen md) {
            MahasiswaDosenController controller = new MahasiswaDosenController(md, bookingManager);
            while (true) {
                System.out.println("\n=== Menu Mahasiswa/Dosen ===");
                System.out.println("1. Lihat Ruangan");
                System.out.println("2. Request Booking");
                System.out.println("3. Lihat Riwayat Booking");
                System.out.println("4. Batalkan Booking");
                System.out.println("5. Logout");
                System.out.print("Pilih menu: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // buang newline

                switch (choice) {
                    case 1:
                        RoomController.lihatRuanganDanJadwal(db.getRooms(), bookingManager, scanner);
                        break;
                    case 2:
                        System.out.print("Masukkan ID Ruangan: ");
                        int roomId = scanner.nextInt();
                        scanner.nextLine();
                        Room selectedRoom = db.getRooms().stream().filter(r -> r.getRoomId() == roomId).findFirst().orElse(null);
                        if (selectedRoom == null) {
                            System.out.println("Ruangan tidak ditemukan.");
                            break;
                        }
                        System.out.print("Tanggal (YYYY-MM-DD): ");
                        LocalDate date = LocalDate.parse(scanner.nextLine());
                        System.out.print("Jam Mulai (HH:MM): ");
                        LocalTime start = LocalTime.parse(scanner.nextLine());
                        System.out.print("Jam Selesai (HH:MM): ");
                        LocalTime end = LocalTime.parse(scanner.nextLine());
                        controller.requestBooking(selectedRoom, date, start, end);
                        break;
                    case 3:
                        controller.viewBookingHistory();
                        break;
                    case 4:
                        System.out.print("Masukkan ID Booking yang ingin dibatalkan: ");
                        int cancelId = scanner.nextInt();
                        controller.cancelBooking(cancelId);
                        break;
                    case 5:
                        System.out.println("Logout...");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        } else if (user instanceof Admin admin) {
            AdminController controller = new AdminController(admin, bookingManager);
            while (true) {
                System.out.println("\n=== Menu Admin ===");
                System.out.println("1. Lihat Ruangan");
                System.out.println("2. Lihat Semua Booking");
                System.out.println("3. Setujui Booking");
                System.out.println("4. Tolak Booking");
                System.out.println("5. Lihat Dashboard");
                System.out.println("6. Request Booking");
                System.out.println("7. Logout");
                System.out.print("Pilih menu: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                     controller.viewRooms(db.getRooms());
                        break;   
                    case 2:
                        controller.viewAllBookings();
                        break;
                    case 3:
                        System.out.print("Masukkan ID Booking: ");
                        int idApprove = scanner.nextInt();
                        controller.approveBooking(idApprove);
                        break;
                    case 4:
                        System.out.print("Masukkan ID Booking: ");
                        int idReject = scanner.nextInt();
                        controller.rejectBooking(idReject);
                        break;
                    case 5:
                        controller.generateDashboard();
                        break;
                    case 6:
                        System.out.print("Masukkan ID Ruangan: ");
                        int roomId = scanner.nextInt();
                        scanner.nextLine();
                        Room selectedRoom = db.getRooms().stream().filter(r -> r.getRoomId() == roomId).findFirst().orElse(null);
                        if (selectedRoom == null) {
                            System.out.println("Ruangan tidak ditemukan.");
                            break;
                        }
                        System.out.print("Tanggal (YYYY-MM-DD): ");
                        LocalDate date = LocalDate.parse(scanner.nextLine());
                        System.out.print("Jam Mulai (HH:MM): ");
                        LocalTime start = LocalTime.parse(scanner.nextLine());
                        System.out.print("Jam Selesai (HH:MM): ");
                        LocalTime end = LocalTime.parse(scanner.nextLine());
                        controller.requestBooking(selectedRoom, date, start, end);
                        break;
                    case 7:
                        System.out.println("Logout...");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
        }    }
    }     
   

       
    

