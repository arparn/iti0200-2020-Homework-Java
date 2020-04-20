package ee.taltech.iti0200.burgerbooth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Food cheeseBurger;
    Food chickenWrap;
    Food bigMac;
    Food cocaCola;

    Map<Food, Integer> order = new HashMap<>();
    Order newOrder;

    @BeforeEach
    void setUp() {
        cheeseBurger = new Food("Cheese Burger");
        chickenWrap = new Food("Chicken Wrap");
        bigMac = new Food("Big Mac");
        cocaCola = new Food("Coca-Cola");

        newOrder = new Order();
    }

    @Test
    void addFoodToOrder() {
        order.put(cheeseBurger, 2);
        order.put(bigMac, 1);
        newOrder.addFoodToOrder(cheeseBurger, 2);
        newOrder.addFoodToOrder(bigMac, 1);
        assertEquals(order, newOrder.getOrderedFood());
    }

    @Test
    void getOrderedFood() {
        order.put(chickenWrap, 2);
        order.put(cocaCola, 1);
        newOrder.addFoodToOrder(chickenWrap, 2);
        newOrder.addFoodToOrder(cocaCola, 1);
        assertEquals(order, newOrder.getOrderedFood());
    }
}