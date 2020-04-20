package ee.taltech.iti0200.burgerbooth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BillTest {

    Map<Food, Integer> orderedFood = new HashMap<>();
    Map<Food, Integer> order = new HashMap<>();
    OrderingMethod.Name orderingMethod;

    Food cheeseBurger;
    Food chickenWrap;
    Food bigMac;
    Food cocaCola;

    Bill bill;


    @BeforeEach
    void setUp() {
        cheeseBurger = new Food("Cheese Burger");
        chickenWrap = new Food("Chicken Wrap");
        bigMac = new Food("Big Mac");
        cocaCola = new Food("Coca-Cola");

        orderedFood.put(cheeseBurger, 1);

        orderingMethod = OrderingMethod.Name.DRIVE_IN;

        LocalTime time = LocalTime.now();
        int minutes = 6;
        time = time.plusMinutes(minutes);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        String timeFormatted = time.format(formatter);

        bill = new Bill(OrderingMethod.Name.DRIVE_IN, "13,2", timeFormatted, orderedFood);

    }

    @Test
    void getOrderedFood() {
        order.put(cheeseBurger, 1);
        assertEquals(order, bill.getOrderedFood());
    }

    @Test
    void getOrderingMethod() {
        assertEquals(OrderingMethod.Name.DRIVE_IN, bill.getOrderingMethod());
    }

    @Test
    void getPrice() {
        assertEquals("13,2", bill.getPrice());
    }

    @Test
    void getTime() {
        LocalTime time = LocalTime.now();
        int minutes = 6;
        time = time.plusMinutes(minutes);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        String newTime = time.format(formatter);
        assertEquals(newTime, bill.getTime());
    }

    @Test
    void orderRewrite() {
        String order = "Cheese Burger, amount: 1";
        assertEquals(order, bill.orderRewrite(orderedFood));
    }

    @Test
    void printCheck() {
        LocalTime time = LocalTime.now();
        int minutes = 6;
        time = time.plusMinutes(minutes);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        String newTime = time.format(formatter);
        String check = "Your order:\n" +
                "Cheese Burger, amount: 1\n" +
                "Ordered in: DRIVE_IN\n" +
                "Total price: 13,2 euro \n" +
                "Order receiving time: " + newTime;
        assertEquals(check, bill.printCheck());
    }
}