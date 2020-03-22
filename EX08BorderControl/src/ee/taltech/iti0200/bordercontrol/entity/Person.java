package ee.taltech.iti0200.bordercontrol.entity;

import ee.taltech.iti0200.bordercontrol.Validator;

public class Person extends BorderEntity {

    String name;
    String idCode;

    public Person(String name, String idCode) {
        this.name = name;
        this.idCode = idCode;
    }

    public String getName() {
        return name;
    }

    public String getIdCode() {
        return idCode;
    }

    @Override
    public String accept(Validator visitor) {
        return visitor.visit(this);
    }

    @Override
    public Long getBorderCrossingId() {
        return Long.parseLong(getIdCode());
    }

    @Override
    public void setBorderCrossingId(Long newBorderCrossingId) {
        idCode = String.valueOf(newBorderCrossingId);
    }
}
