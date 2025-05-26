package model;

public class Room {
    private int roomId;
    private String roomName;
    private int capacity;
    private String type;

    public Room(int roomId, String roomName, int capacity, String type) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.type = type;
    }

    public int getRoomId() { return roomId; }
    public String getRoomName() { return roomName; }
    public int getCapacity() { return capacity; }
    public String getType() { return type; }
}