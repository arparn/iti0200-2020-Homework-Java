package ee.taltech.iti0200.bordercontrol.entity;

public class Vehicle extends BorderEntity{

    String vin;

    public Vehicle(String vin) {
        this.vin = vin;
    }

    public Long getVin() {
        return (long) Integer.parseInt(vin);
    }


    @Override
    public Long getBorderCrossingId() {
        return getVin();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setBorderCrossingId(Long newBorderCrossingId) {
        vin = String.valueOf(newBorderCrossingId);
    }
}
