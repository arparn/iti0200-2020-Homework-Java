package ee.taltech.iti0200.burgerbooth;

import java.util.HashMap;
import java.util.Map;

public class OrderingMethodStrategy {

    protected Kitchen kitchen;
    protected String name;

    protected Order order = new Order();

    protected Map<Food, Integer> menu = new HashMap<>();

    public OrderingMethodStrategy(Kitchen kitchen, String name) {
        this.kitchen = kitchen;
        this.name = name;
    }

    public Map<Food, Integer> getMenu() {
        return kitchen.getFoodInFridge();
    }

    public Order getOrder() {
        return this.order;
    }

    public void makeOrder(Food food, int amount) {
        Map<Food, Integer> foodInFridge = this.kitchen.getFoodInFridge();
        if (foodInFridge.containsKey(food) && foodInFridge.get(food) - amount >= 0) {
            if (foodInFridge.get(food) - amount > 0) {
                foodInFridge.replace(food, foodInFridge.get(food) - amount);
            } else {
                foodInFridge.remove(food);
            }
            this.order.addFoodToOrder(food, amount);
        } else {
            System.out.println("Sorry, we cant cook this. Please insert the correct food name and amount from menu.");
        }
    }

    public void removeFoodFromOrder(Food food, Integer amount) {
        Map<Food, Integer> orderedFood = this.order.getOrderedFood();
        if (orderedFood.containsKey(food)) {
            if (orderedFood.get(food) - amount <= 0) {
                this.kitchen.addFood(food, orderedFood.get(food));
                orderedFood.remove(food);
            } else {
                this.kitchen.addFood(food, amount);
                orderedFood.replace(food, orderedFood.get(food) - amount);
            }
        }
    }

    public String getName() {
        return this.name;
    }
}
