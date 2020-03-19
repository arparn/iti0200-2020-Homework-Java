package ee.taltech.iti0200.bordercontrol.entity;

public class Person extends BorderEntity{

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
    Long getBorderCrossingId() {
        return Long.parseLong(idCode);
    }

    @Override
    void setBorderCrossingId(Long newBorderCrossingId) {
        idCode = String.valueOf(newBorderCrossingId);
    }
}
