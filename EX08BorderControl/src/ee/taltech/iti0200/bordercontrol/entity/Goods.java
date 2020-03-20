package ee.taltech.iti0200.bordercontrol.entity;

public class Goods extends BorderEntity {

    Long productId;

    public Goods(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    @Override
    public Long getBorderCrossingId() {
        return getProductId();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setBorderCrossingId(Long newBorderCrossingId) {
        productId = newBorderCrossingId;
    }
}
