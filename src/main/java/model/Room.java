package model;

import java.util.Objects;

public class Room {
    private int roomId;
    private String roomName;

    public Room(int roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public int getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public String toString() {
        return "ID :" + roomId + " - " + roomName;
    }

}