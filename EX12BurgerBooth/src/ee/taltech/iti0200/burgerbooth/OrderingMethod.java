package ee.taltech.iti0200.burgerbooth;

import java.util.HashMap;
import java.util.Map;

public class OrderingMethod {

    protected Kitchen kitchen;

    public enum Name {
        CASH_DESK, SELF_SERVICE_CASH_DESK, DRIVE_IN
    }

    protected Name name;

    protected Order order = new Order();

    protected Map<Food, Integer> menu = new HashMap<>();

    public OrderingMethod(Kitchen kitchen, Name name) {
        this.kitchen = kitchen;
        this.name = name;
    }

    public String getMenu() {
        StringBuilder answer = new StringBuilder();
        int flag = 0;
        for (Food food : kitchen.fridge.keySet()) {
            answer.append(food.getName()).append(", amount: ").append(kitchen.fridge.get(food));
            flag ++;
            if (flag < kitchen.fridge.size()) {
                answer.append("\n");
            }
        }
        return answer.toString();
    }

    public Order getOrder() {
        return this.order;
    }

    public String getOrderReview() {
        StringBuilder answer = new StringBuilder();
        int flag = 0;
        for (Food food : order.getOrderedFood().keySet()) {
            answer.append(food.getName()).append(", amount: ").append(order.getOrderedFood().get(food));
            flag ++;
            if (flag < order.getOrderedFood().size()) {
                answer.append("\n");
            }
        }
        return answer.toString();
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

    public Name getName() {
        return this.name;
    }

    public void clearOrder() {
        this.order = new Order();
    }
}
