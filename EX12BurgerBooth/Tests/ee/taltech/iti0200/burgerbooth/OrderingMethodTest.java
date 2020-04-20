package ee.taltech.iti0200.burgerbooth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderingMethodTest {

    Food cheeseBurger;
    Food chickenWrap;
    Food bigMac;
    Food cocaCola;

    Kitchen kitchen;

    OrderingMethod cashDesk;
    OrderingMethod selfService;
    OrderingMethod driveIn;

    String menu;

    @BeforeEach
    void setUp() {
        cheeseBurger = new Food("Cheese Burger");
        chickenWrap = new Food("Chicken Wrap");
        bigMac = new Food("Big Mac");
        cocaCola = new Food("Coca-Cola");

        kitchen = new Kitchen();

        kitchen.addFood(cocaCola, 5);

        cashDesk = new OrderingMethod(kitchen, OrderingMethod.Name.CASH_DESK);
        selfService = new OrderingMethod(kitchen, OrderingMethod.Name.SELF_SERVICE_CASH_DESK);
        driveIn = new OrderingMethod(kitchen, OrderingMethod.Name.DRIVE_IN);

        menu = "Coca-Cola, amount: 5";

    }

    @Test
    void getMenu() {
        assertEquals(menu, selfService.getMenu());
    }

    @Test
    void getOrder() {
        driveIn.makeOrder(bigMac, 1);
        String orderId = driveIn.getOrder().toString();
        assertEquals(orderId, driveIn.getOrder().toString());
    }

    @Test
    void getOrderReview() {
        kitchen.addFood(chickenWrap, 3);
        selfService.makeOrder(chickenWrap, 1);
        String orderReview = "Chicken Wrap, amount: 1";
        assertEquals(orderReview, selfService.getOrderReview());
    }

    @Test
    void makeOrder() {
        kitchen.addFood(chickenWrap, 3);
        driveIn.makeOrder(chickenWrap, 1);
        String order = "Chicken Wrap, amount: 1";
        assertEquals(order, driveIn.getOrderReview());
    }

    @Test
    void removeFoodFromOrder() {
        kitchen.addFood(bigMac, 4);
        kitchen.addFood(chickenWrap, 3);
        cashDesk.makeOrder(bigMac, 1);
        cashDesk.makeOrder(chickenWrap, 1);
        cashDesk.removeFoodFromOrder(chickenWrap, 1);
        String order = "Big Mac, amount: 1";
        assertEquals(order, cashDesk.getOrderReview());
    }

    @Test
    void getName() {
        assertEquals(OrderingMethod.Name.CASH_DESK, cashDesk.getName());
    }

    @Test
    void clearOrder() {
        cashDesk.makeOrder(cocaCola, 1);
        cashDesk.makeOrder(chickenWrap, 1);
        cashDesk.clearOrder();
        assertEquals("", cashDesk.getOrderReview());
    }
}