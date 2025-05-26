package main;

import controller.BookingController;
import model.Mahasiswa;
import model.User;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Aplikasi Reservasi Ruang Kampus");
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan email: ");
        String email = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        User currentUser = new Mahasiswa(1, nama, email, password);
        BookingController controller = new BookingController();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Lihat Ruangan");
            System.out.println("2. Buat Booking");
            System.out.println("3. Lihat Semua Booking");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> controller.listRooms();
                case 2 -> controller.bookRoom(currentUser, scanner);
                case 3 -> controller.listBookings();
                case 0 -> {
                    System.out.println("Terima kasih!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
