package ee.taltech.iti0200.steakhouse.steak;

public class Steak {

    private String cookName;
    private double weight;

    public Steak(String name, double steakWeight) {
        this.cookName = name;
        this.weight = steakWeight;
    }

    public void setCookName(String name) {
        cookName = name;
    }

    public String getCookName() {
        return cookName;
    }

    public void setWeight(double newWeight) {
        weight = newWeight;
    }

    public double getWeight() {
        return weight;
    }

}
