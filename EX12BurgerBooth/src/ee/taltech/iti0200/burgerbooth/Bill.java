package ee.taltech.iti0200.burgerbooth;

import java.time.LocalTime;
import java.util.Map;

public class Bill {

    private Map<Food, Integer> orderedFood;
    private String orderingMethod;
    private float price;
    private LocalTime time;

    public Bill(String orderingMethod, Float price, LocalTime time, Map<Food, Integer> orderedFood) {
        this.orderedFood = orderedFood;
        this.orderingMethod = orderingMethod;
        this.price = price;
        this.time = time;
    }

    public Map<Food, Integer> getOrderedFood() {
        return orderedFood;
    }

    public String getOrderingMethod() {
        return orderingMethod;
    }

    public float getPrice() {
        return price;
    }

    public LocalTime getTime() {
        return time;
    }

    public String printCheck() {
        return "Your order:" + "\n" + orderedFood + "\nPayment method: " + orderingMethod
                + "\nTotal price: " + price + "\nCooking time: " + time;
    }
}
