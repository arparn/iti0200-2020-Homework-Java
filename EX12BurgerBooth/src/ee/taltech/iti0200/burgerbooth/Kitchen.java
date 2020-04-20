package ee.taltech.iti0200.burgerbooth;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Kitchen {

    public List<Bill> restoranHistory = new LinkedList<>();

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

    public String getRestoHistory() {
        StringBuilder answer = new StringBuilder();
        int flag = 0;
        for (Bill bill: restoranHistory) {
            answer.append("Ordered food:\n").append(bill.orderRewrite(bill.getOrderedFood())).append("\nPrice: ").append(bill.getPrice())
                    .append("\nOrdered in: ").append(bill.getOrderingMethod())
                    .append("\nOrder receiving time: "). append(bill.getTime());
            flag ++;
            if (flag < restoranHistory.size()) {
                answer.append("\n-----------------------------------");
                answer.append("\n");
            }
        }
        return answer.toString();
    }

    public String getFoodReview() {
        StringBuilder answer = new StringBuilder();
        int flag = 0;
        for (Food food : getFoodInFridge().keySet()) {
            answer.append(food.getName()).append(", amount: ").append(getFoodInFridge().get(food));
            flag ++;
            if (flag < getFoodInFridge().size()) {
                answer.append("\n");
            }
        }
        return answer.toString();
    }

    public String calcPrice(OrderingMethod orderingMethod) {
        Map<Food, Integer> orderedFood = orderingMethod.getOrder().getOrderedFood();
        int products = 0;
        for (Food food : orderedFood.keySet()) {
            products += orderedFood.get(food) + (food.getName().length() / 2);
        }
        DecimalFormat df = new DecimalFormat("###.###");
        if (orderingMethod.getName().equals(OrderingMethod.Name.SELF_SERVICE_CASH_DESK)) {
            return df.format((products * 1.2) - ((products * 1.2) * 0.15));
        } else {
            return df.format(products * 1.2);
        }
    }

    public int calcTime(OrderingMethod orderingMethod) {
        Map<Food, Integer> orderedFood = orderingMethod.getOrder().getOrderedFood();
        int products = 0;
        for (Food food : orderedFood.keySet()) {
            products += orderedFood.get(food);
        }
        if (orderingMethod.getName().equals(OrderingMethod.Name.DRIVE_IN)) {
            return (products * 3) / 2;
        } else {
            return products * 3;
        }
    }

    public Bill cookOrder(OrderingMethod orderingMethod) {
        OrderingMethod.Name name = orderingMethod.getName();
        Map<Food, Integer> orderedFood = orderingMethod.getOrder().getOrderedFood();
        String price = calcPrice(orderingMethod);
        LocalTime time = LocalTime.now();
        int minutes = calcTime(orderingMethod);
        time = time.plusMinutes(minutes);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        String timeFormatted = time.format(formatter);
        orderingMethod.clearOrder();
        Bill bill = new Bill(name, price, timeFormatted, orderedFood);
        restoranHistory.add(bill);
        return bill;
    }
}
