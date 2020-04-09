package ee.taltech.iti0200.cakeorder;

import java.util.List;

public class Cake {

    private String cake_id = "";
    private String name;
    private String BBD;
    private double price;
    private double kg;
    List<String> ingredients;

    public Cake() { }

    public void  setCake_id() {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < this.name.length(); i++) {
            if (i == 0) {
                answer.append(Character.toString(this.name.charAt(i)).toUpperCase());
            } else if (Character.toString(this.name.charAt(i)).equals(" ")) {
                answer.append(Character.toString(this.name.charAt(i + 1)).toUpperCase());
            }
        }
        int num = answer.toString().length();
        this.cake_id = answer.toString() + num;
    }

    public String getName() {
        return this.name;
    }

    public String getBBD() {
        return this.BBD;
    }

    public double getPrice() {
        return this.price;
    }

    public double getKg() {
        return this.kg;
    }

    public List<String> getIngredients() {
        return this.ingredients;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public void setIngredients(List<String> newIngredients) {
        this.ingredients = newIngredients;
    }

}
