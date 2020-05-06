package ee.taltech.iti0200.kt1.hotel;

import java.util.LinkedList;
import java.util.List;

public class Hotel {

    List<Room> rooms = new LinkedList<>();
    List<Room> reservedRooms = new LinkedList<>();
    List<Room> availableRooms = new LinkedList<>();

    private String name;

    public Hotel(String name) {
        this.name = name;
    }

    public boolean addRoom(Room room) {
        boolean check = true;
        for (Room room1 : rooms) {
            if (room1.getNumber() == room.getNumber()) {
                check = false;
                break;
            }
        }
        if (check) {
            availableRooms.add(room);
            rooms.add(room);
        }
        return check;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Room> getReservedRooms() {
        return reservedRooms;
    }

    public String getName() {
        return name;
    }

    public List<Room> getAvailableRooms() {
        return availableRooms;
    }

    public boolean makeReservation(Room room) {
        if (rooms.contains(room) && !reservedRooms.contains(room)) {
            reservedRooms.add(room);
            availableRooms.remove(room);
            return true;
        } else {
            return false;
        }
    }

    public boolean cancelBooking(Room room) {
        if (!room.getType().equals(Room.Type.Suite) && reservedRooms.contains(room)) {
            reservedRooms.remove(room);
            availableRooms.add(room);
            return true;
        } else {
            return false;
        }
    }

    public List<Room> findRoomBySize(int size) {
        List<Room> roomList = new LinkedList<>();
        for (Room room : availableRooms) {
            if (room.getSize() >= size) {
                roomList.add(room);
            }
        }
        return roomList;
    }
}
