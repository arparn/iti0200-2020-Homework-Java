package ee.taltech.iti0200.cakeorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;


public class CakeOrderProcessor {

    private int orderNumber = 0;

    public enum CakeOrderProcessorType {

        MAKE_DAIRY_FREE,
        COUNT_TOTAL_SUM,
        REMOVE_BEST_BEFORE_DAY_OVER

    }

    private CakeOrderProcessorType type;


    public CakeOrderProcessor(CakeOrderProcessorType type) {
        this.type = type;
    }

    public String process(String jsonInput) {
        orderNumber++;
        double totalPrice = 0;
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        Order order = gson.fromJson(jsonInput, Order.class);
        order.setOrder_id(orderNumber);
        List<Cake> cakes = order.getCakes();
        if (this.type.equals(CakeOrderProcessorType.MAKE_DAIRY_FREE)) {
            for (Cake cake : cakes) {
                cake.setCake_id();
                int flag = 0;
                List<String> ingredients = cake.getIngredients();
                for (String ingredient : ingredients) {
                    if (ingredient.equals("milk") || ingredient.equals("cream-cheese") || ingredient.equals("yoghurt")) {
                        flag++;
                        int index = ingredients.indexOf(ingredient);
                        ingredients.set(index, "plant-" + ingredient);
                    }
                }
                cake.setIngredients(ingredients);
                if (flag > 0) {
                    cake.setPrice((cake.getPrice() * (100 + (flag * 10))) / 100);
                }
            }
        } else if (this.type.equals(CakeOrderProcessorType.COUNT_TOTAL_SUM)) {
            OrderTotal orderTotal = gson.fromJson(jsonInput, OrderTotal.class);
            orderTotal.setOrder_id(orderNumber);
            List<Cake> cakes1 = orderTotal.getCakes();
            for (Cake cake : cakes1) {
                cake.setCake_id();
                totalPrice += cake.getPrice() * cake.getKg();
            }
            orderTotal.setTotal(totalPrice);
            return gson.toJson(orderTotal);
        } else if (this.type.equals(CakeOrderProcessorType.REMOVE_BEST_BEFORE_DAY_OVER)) {
            List<Cake> cakesToRemove = new LinkedList<>();
            for (Cake cake : cakes) {
                cake.setCake_id();
                LocalDate currentDate = LocalDate.now();
                LocalDate BBD = LocalDate.parse(cake.getBBD());
                if (currentDate.compareTo(BBD) >= 0) {
                    cakesToRemove.add(cake);
                }
            }
            for (Cake cake : cakesToRemove) {
                cakes.remove(cake);
            }
        }
        return gson.toJson(order);
    }
}
