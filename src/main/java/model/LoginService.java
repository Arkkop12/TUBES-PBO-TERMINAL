package model;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    private List<Admin> adminList = new ArrayList<>();
    private List<MahasiswaDosen> userList = new ArrayList<>();

    public LoginService() {
        // Data dummy
        adminList.add(new Admin(1, "Admin Satu", "admin@example.com"));
        userList.add(new MahasiswaDosen(2, "Doni Mahasiswa", "doni@example.com", "mahasiswa"));
        userList.add(new MahasiswaDosen(3, "Dedi Dosen", "dedi@example.com", "dosen"));
    }

    public Object login(String email) {
        for (Admin a : adminList) {
            if (a.email.equals(email)) {
                return a;
            }
        }
        for (MahasiswaDosen u : userList) {
            if (u.email.equals(email)) {
                return u;
            }
        }
        return null;
    }
}
