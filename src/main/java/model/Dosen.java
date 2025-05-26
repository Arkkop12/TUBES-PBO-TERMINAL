package model;

public class Dosen extends User {
    public Dosen(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    @Override
    public String getRole() {
        return "dosen";
    }
}
