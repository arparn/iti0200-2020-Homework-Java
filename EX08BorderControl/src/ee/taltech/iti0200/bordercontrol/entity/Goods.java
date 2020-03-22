package ee.taltech.iti0200.bordercontrol.entity;

import ee.taltech.iti0200.bordercontrol.Validator;

public class Goods extends BorderEntity {

    Long productId;

    public Goods(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String accept(Validator visitor) {
        return visitor.visit(this);
    }

    @Override
    public Long getBorderCrossingId() {
        return getProductId();
    }

    @Override
    public void setBorderCrossingId(Long newBorderCrossingId) {
        productId = newBorderCrossingId;
    }
}
