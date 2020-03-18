package ee.taltech.iti0200.steakhouse;

import ee.taltech.iti0200.steakhouse.steak.Steak;

import java.util.ArrayDeque;

import static ee.taltech.iti0200.steakhouse.steak.SteakType.FILET_MIGNON;

public class Kitchen {

    String chefCook;
    ArrayDeque<String> allCooks = new ArrayDeque<>();

    public Kitchen(String chefCook) {
        this.chefCook = chefCook;
    }

    public Steak makeOrder(Order order) {
        if (order.getSteakType().equals(FILET_MIGNON)) {
            return new Steak(chefCook, order.getSteakType().getWeight());
        } else {
            String cook = allCooks.pollFirst();
            Steak steak = new Steak(cook, order.getSteakType().getWeight());
            allCooks.addLast(cook);
            return steak;
        }
    }

    void addCook(String cookName) {
        allCooks.add(cookName);
    }

    public ArrayDeque<String> getAllCooks() {
        return allCooks;
    }
}
