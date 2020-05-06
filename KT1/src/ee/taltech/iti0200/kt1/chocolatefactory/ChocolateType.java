package ee.taltech.iti0200.kt1.chocolatefactory;

public class ChocolateType {

    private int price;
    private String str;

    public ChocolateType(int price, String str) {
        this.price = price;
        this.str = str;
    }

    public int getPricePerPiece() {
        return price;
    }

    public String getStringForm() {
        return str;
    }
}
