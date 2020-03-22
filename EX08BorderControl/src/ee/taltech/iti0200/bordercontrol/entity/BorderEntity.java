package ee.taltech.iti0200.bordercontrol.entity;


import ee.taltech.iti0200.bordercontrol.Validator;

public abstract class BorderEntity {

    public abstract String getName();

    public abstract String accept(Validator visitor);

    public abstract Long getBorderCrossingId();

    public abstract void setBorderCrossingId(Long newBorderCrossingId);
}
