package model;

public class Room {
    private int id;
    private String roomName;
    private int capacity;
    private String description;
    private boolean available = true;

    public Room(int id, String roomName, int capacity, String description) {
        this.id = id;
        this.roomName = roomName;
        this.capacity = capacity;
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getRoomName() {
        return roomName;
    }
}
