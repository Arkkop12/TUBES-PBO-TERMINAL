package model;

public class Admin extends UserAdmin {
    public Admin(int id, String name, String email) {
        super(id, name, email, "admin");
    }

    @Override
    public void login() {
        System.out.println("Admin login: " + name);
    }

    @Override
    public void logout() {
        System.out.println("Admin logout.");
    }

    @Override
    public void requestBooking() {
        System.out.println("Admin request booking.");
    }

    public void approveBooking() {
        System.out.println("Booking disetujui.");
    }

    public void rejectBooking() {
        System.out.println("Booking ditolak.");
    }

    public void viewAllBooking() {
        System.out.println("Menampilkan semua booking.");
    }

    public void generateDashboard() {
        System.out.println("Dashboard statistik ditampilkan.");
        System.out.println("- Total booking: 5");
        System.out.println("- Jumlah ruangan tersedia: 3");
        System.out.println("- Ruangan terpopuler: Ruang 101");
    }
}
