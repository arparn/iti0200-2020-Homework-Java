package ee.taltech.iti0200.cakeorder;

import java.util.List;

public class Order {

    private int order_id;
    List<Cake> cakes;

    public Order(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public List<Cake> getCakes() {
        return this.cakes;
    }
}
