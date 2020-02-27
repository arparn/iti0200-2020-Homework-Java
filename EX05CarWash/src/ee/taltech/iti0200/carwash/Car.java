package ee.taltech.iti0200.carwash;

public class Car {
    private int dirtiness;

    public Car(int dirtiness) {
        this.dirtiness = dirtiness;
    }

    public void setDirtiness(int newDirtiness) {
        dirtiness = Math.max(newDirtiness, 0);
    }

    public int getDirtiness() {
        return dirtiness;
    }
}