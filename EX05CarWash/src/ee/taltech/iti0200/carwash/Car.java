package ee.taltech.iti0200.carwash;

public class Car {
    private int dirtiness;

    public Car(int dirtiness) {
        this.dirtiness = dirtiness;
    }

    public void setDirtiness(int newDirtiness) {
        if (dirtiness - newDirtiness < 0) {
            dirtiness = 0;
        } else {
            dirtiness = newDirtiness;
        }
    }

    public int getDirtiness() {
        return dirtiness;
    }
}