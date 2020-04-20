package ee.taltech.iti0200.burgerbooth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class KitchenTest {
    Food cheeseBurger;
    Food chickenWrap;
    Food bigMac;
    Food cocaCola;

    Kitchen kitchen;

    OrderingMethod cashDesk;
    OrderingMethod selfService;
    OrderingMethod driveIn;

    String menu;

    Map<Food, Integer> fridge = new HashMap<>();

    @BeforeEach
    void setUp() {
        cheeseBurger = new Food("Cheese Burger");
        chickenWrap = new Food("Chicken Wrap");
        bigMac = new Food("Big Mac");
        cocaCola = new Food("Coca-Cola");

        kitchen = new Kitchen();

        cashDesk = new OrderingMethod(kitchen, OrderingMethod.Name.CASH_DESK);
        selfService = new OrderingMethod(kitchen, OrderingMethod.Name.SELF_SERVICE_CASH_DESK);
        driveIn = new OrderingMethod(kitchen, OrderingMethod.Name.DRIVE_IN);

        menu = "Coca-Cola, amount: 5\n" +
                "Chicken Wrap, amount: 8\n" +
                "Cheese Burger, amount: 2\n" +
                "Big Mac, amount: 3";

    }

    @Test
    void addFood() {
        fridge.put(bigMac, 4);
        kitchen.addFood(bigMac, 4);
        assertEquals(fridge, kitchen.getFoodInFridge());
    }

    @Test
    void getFoodInFridge() {
        fridge.put(cocaCola, 5);
        kitchen.addFood(cocaCola, 5);
        assertEquals(fridge, kitchen.getFoodInFridge());
    }

    @Test
    void getRestoHistory() {
        kitchen.addFood(chickenWrap, 3);
        driveIn.makeOrder(chickenWrap, 1);
        kitchen.cookOrder(driveIn);
        LocalTime time = LocalTime.now();
        int minutes = 1;
        time = time.plusMinutes(minutes);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        String timeFormatted = time.format(formatter);
        String history = "Ordered food:\n" +
                "Chicken Wrap, amount: 1\n" +
                "Price: 8,4\n" +
                "Ordered in: DRIVE_IN\n" +
                "Order receiving time: " + timeFormatted;
        assertEquals(history, kitchen.getRestoHistory());
    }

    @Test
    void getFoodReview() {
        kitchen.addFood(cheeseBurger, 4);
        cashDesk.makeOrder(cheeseBurger, 1);
        kitchen.cookOrder(cashDesk);
        String review = "Cheese Burger, amount: 3";
        assertEquals(review, kitchen.getFoodReview());
    }

    @Test
    void calcPrice() {
        kitchen.addFood(bigMac, 5);
        driveIn.makeOrder(bigMac, 2);
        String price = "6";
        assertEquals(price, kitchen.calcPrice(driveIn));
    }

    @Test
    void calcTime() {
        kitchen.addFood(cocaCola, 5);
        selfService.makeOrder(cocaCola, 4);
        int time = 12;
        assertEquals(time, kitchen.calcTime(selfService));
    }

    @Test
    void cookOrder() {
        kitchen.addFood(cheeseBurger, 8);
        cashDesk.makeOrder(cheeseBurger, 6);
        LocalTime time = LocalTime.now();
        int minutes = 18;
        time = time.plusMinutes(minutes);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        String timeFormatted = time.format(formatter);
        String bill = "Your order:\n" +
                "Cheese Burger, amount: 6\n" +
                "Ordered in: CASH_DESK\n" +
                "Total price: 14,4 euro \n" +
                "Order receiving time: " + timeFormatted;
        assertEquals(bill, kitchen.cookOrder(cashDesk).printCheck());
    }
}