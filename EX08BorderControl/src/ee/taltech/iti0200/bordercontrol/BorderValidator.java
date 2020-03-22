package ee.taltech.iti0200.bordercontrol;

import ee.taltech.iti0200.bordercontrol.database.Database;
import ee.taltech.iti0200.bordercontrol.entity.Goods;
import ee.taltech.iti0200.bordercontrol.entity.Person;
import ee.taltech.iti0200.bordercontrol.entity.Vehicle;

public class BorderValidator implements Validator {

    Database database;

    public BorderValidator(Database database) {
        this.database = database;
    }


    @Override
    public String visit(Person person) {
        return person.getBorderCrossingId().toString();
    }

    @Override
    public String visit(Vehicle vehicle) {
        return vehicle.getBorderCrossingId().toString();
    }

    @Override
    public String visit(Goods goods) {
        return goods.getBorderCrossingId().toString();
    }

    @Override
    public Database getDatabase() {
        return database;
    }

    @Override
    public void setDatabase(Database database) {
        this.database = database;
    }
}
