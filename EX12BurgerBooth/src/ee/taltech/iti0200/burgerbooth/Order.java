package ee.taltech.iti0200.burgerbooth;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<Food, Integer> orderedFood = new HashMap<>();

    public void addFoodToOrder(Food food, int amount) {
        if (orderedFood.containsKey(food)) {
            orderedFood.replace(food, orderedFood.get(food) + amount);
        } else {
            orderedFood.put(food, amount);
        }
    }

    public Map<Food, Integer> getOrderedFood() {
        return this.orderedFood;
    }
}
