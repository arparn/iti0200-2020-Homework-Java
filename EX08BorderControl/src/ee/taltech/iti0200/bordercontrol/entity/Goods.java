package ee.taltech.iti0200.bordercontrol.entity;

public class Goods extends BorderEntity {

    long productId;

    public Goods(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    @Override
    Long getBorderCrossingId() {
        return productId;
    }

    @Override
    void setBorderCrossingId(Long newBorderCrossingId) {
        productId = newBorderCrossingId;
    }
}
