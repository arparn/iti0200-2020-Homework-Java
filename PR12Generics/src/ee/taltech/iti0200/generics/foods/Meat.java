package ee.taltech.iti0200.generics.foods;

public class Meat extends Food {

    private String name;

    public Meat() {
        this.name = "MEAT";
    }

    @Override
    public String getName() {
        return this.name;
    }
}
