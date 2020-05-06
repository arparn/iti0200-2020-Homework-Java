package ee.taltech.iti0200.kt1.hotel;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Viru");
        Room room1 = new Room(1, 10, Room.Type.Regular);
        Room room2 = new Room(1, 12, Room.Type.Regular);
        Room room3 = new Room(2, 15, Room.Type.Regular);
        Room room4 = new Room(3, 10, Room.Type.Regular);
        Room room5 = new Room(4, 25, Room.Type.Suite);

        hotel.addRoom(room1);
        System.out.println(hotel.addRoom(room2)); // false
        System.out.println(hotel.addRoom(room1)); // false
        hotel.addRoom(room3);
        hotel.addRoom(room4);
        hotel.addRoom(room5);
        System.out.println("All rooms:");
        for (Room room : hotel.getRooms()) {
            System.out.println(room.getNumber()); // 1, 2, 3, 4
        }
        System.out.println("Available:___________________________");
        for (Room room : hotel.getAvailableRooms()) {
            System.out.println(room.getNumber()); // 1, 2, 3, 4
        }
        System.out.println("Reserved:___________________________");
        hotel.makeReservation(room1);
        for (Room room : hotel.getReservedRooms()) {
            System.out.println(room.getNumber()); // 1
        }
        System.out.println("Available:___________________________");
        for (Room room : hotel.getAvailableRooms()) {
            System.out.println(room.getNumber()); // 2, 3, 4
        }
        System.out.println("Cancel booking:");
        hotel.cancelBooking(room1);
        System.out.println("Reserved:___________________________");
        for (Room room : hotel.getReservedRooms()) {
            System.out.println(room.getNumber()); //
        }
        System.out.println("Available:___________________________");
        for (Room room : hotel.getAvailableRooms()) {
            System.out.println(room.getNumber()); // 2, 3, 4, 1
        }
        System.out.println("Reserving Suite:");
        hotel.makeReservation(room5);
        System.out.println("Reserved:___________________________");
        for (Room room : hotel.getReservedRooms()) {
            System.out.println(room.getNumber()); // 4
        }
        System.out.println("Available:___________________________");
        for (Room room : hotel.getAvailableRooms()) {
            System.out.println(room.getNumber()); // 2, 3, 1
        }
        System.out.println("Cancel booking:");
        System.out.println(hotel.cancelBooking(room5)); // false
        System.out.println("Find room:");
        for (Room room : hotel.findRoomBySize(12)) {
            System.out.println(room.getNumber()); // 2
        }
    }
}
