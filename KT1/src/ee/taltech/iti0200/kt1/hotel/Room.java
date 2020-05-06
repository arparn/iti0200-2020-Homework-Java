package ee.taltech.iti0200.kt1.hotel;

public class Room {

    private int number;
    private int size;
    private Type type;

    public enum Type {
        Suite,
        Regular
    }

    public Room(int number, int size, Type type) {
        this.number = number;
        this.size = size;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }
}
