package ee.taltech.iti0200.burgerbooth;

import java.util.Map;

public class Bill {

    private Map<Food, Integer> orderedFood;
    private OrderingMethod.Name orderingMethod;
    private String price;
    private String time;

    public Bill(OrderingMethod.Name orderingMethod, String price, String time, Map<Food, Integer> orderedFood) {
        this.orderedFood = orderedFood;
        this.orderingMethod = orderingMethod;
        this.price = price;
        this.time = time;
    }

    public Map<Food, Integer> getOrderedFood() {
        return orderedFood;
    }

    public OrderingMethod.Name getOrderingMethod() {
        return orderingMethod;
    }

    public String getPrice() {
        return price;
    }

    public String getTime() {
        return time;
    }

    public String orderRewrite(Map<Food, Integer> orderedFood) {
        StringBuilder answer = new StringBuilder();
        int flag = 0;
        for (Food food : orderedFood.keySet()) {
            answer.append(food.getName()).append(", amount: ").append(orderedFood.get(food));
            flag ++;
            if (flag < orderedFood.size()) {
                answer.append("\n");
            }
        }
        return answer.toString();
    }

    public String printCheck() {
        return "Your order:" + "\n" + orderRewrite(orderedFood) + "\nOrdered in: " + orderingMethod
                + "\nTotal price: " + price + " euro \nOrder receiving time: " + time;
    }
}
