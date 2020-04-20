package ee.taltech.iti0200.burgerbooth;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Kitchen {

    public Map<Food, Integer> fridge = new HashMap<>();

    public void addFood(Food food, int amount) {
        if (fridge.containsKey(food)) {
            fridge.replace(food, fridge.get(food) + amount);
        } else {
            fridge.put(food, amount);
        }
    }

    public Map<Food, Integer> getFoodInFridge() {
        return this.fridge;
    }

    public Float calcPrice(OrderingMethodStrategy orderingMethodStrategy) {
        Map<Food, Integer> orderedFood = orderingMethodStrategy.getOrder().getOrderedFood();
        int products = orderedFood.keySet().size();
        return (float) products / orderingMethodStrategy.getName().length();
    }

    public int calcTime(OrderingMethodStrategy orderingMethodStrategy) {
        Map<Food, Integer> orderedFood = orderingMethodStrategy.getOrder().getOrderedFood();
        int products = orderedFood.keySet().size();
        return products * orderingMethodStrategy.getName().length();
    }

    public Bill cookOrder(OrderingMethodStrategy orderingMethod) {
        String name = orderingMethod.getName();
        Map<Food, Integer> orderedFood = orderingMethod.getOrder().getOrderedFood();
        float price = calcPrice(orderingMethod);
        LocalTime time = LocalTime.now();
        int minutes = calcTime(orderingMethod);
        time = time.plusMinutes(minutes);
        return new Bill(name, price, time, orderedFood);
    }
}
