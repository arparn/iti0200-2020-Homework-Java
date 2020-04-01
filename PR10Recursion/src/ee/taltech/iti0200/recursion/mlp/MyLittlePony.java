package ee.taltech.iti0200.recursion.mlp;

public class MyLittlePony {

    public enum PonyType {
        EARTH_PONY, UNICORN, ALICORN, PEGASUS
    }

    private String name;
    private PonyType ponyType;

    public MyLittlePony(String name, PonyType ponyType) {
        this.name = name;
        this.ponyType = ponyType;
    }

    public String getName() {
        return this.name;
    }

    public PonyType getPonyType() {
        return this.ponyType;
    }
}
