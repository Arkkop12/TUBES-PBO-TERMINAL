package main;

import controller.AdminController;
import controller.MahasiswaDosenController;
import model.*;
import service.LoginService;
import Storage.Database;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Database db = new Database();
        BookingManager bookingManager = new BookingManager(db.getBookings());

        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService();

        System.out.println("Selamat datang di Sistem Reservasi Ruangan");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Object user = loginService.login(username, password);
        if (user instanceof Admin) {
            Admin admin = (Admin) user;
            AdminController adminController = new AdminController(admin, bookingManager);
            adminController.generateDashboard();
            adminController.viewAllBookings();
            adminController.approveBooking(1);
        } else if (user instanceof MahasiswaDosen) {
            MahasiswaDosen md = (MahasiswaDosen) user;
            MahasiswaDosenController controller = new MahasiswaDosenController(md, bookingManager);
            controller.checkAvailability(db.getRooms());
            controller.requestBooking(
                    db.getRooms().get(0),
                    LocalDate.now(),
                    LocalTime.of(10, 0),
                    LocalTime.of(12, 0)
            );
            controller.viewBookingHistory();
        } else {
            System.out.println("Login gagal!");
        }

        scanner.close();
    }
}
