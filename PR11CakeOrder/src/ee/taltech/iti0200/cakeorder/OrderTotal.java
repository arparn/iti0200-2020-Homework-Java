package ee.taltech.iti0200.cakeorder;

import java.util.List;

public class OrderTotal {
    private int order_id;
    private double total;
    List<Cake> cakes;

    public OrderTotal(List<Cake> cakes) {
        this.cakes = cakes;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public List<Cake> getCakes() {
        return this.cakes;
    }
}
