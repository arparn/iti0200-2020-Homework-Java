package ee.taltech.iti0200.bordercontrol.entity;


public abstract class BorderEntity {

    public abstract Long getBorderCrossingId();

    public abstract String getName();

    public abstract void setBorderCrossingId(Long newBorderCrossingId);
}
