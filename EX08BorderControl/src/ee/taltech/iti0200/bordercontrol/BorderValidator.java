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
    public boolean visit(Person person) {
        return (database.getMissingPersons().contains(person.getIdCode())
                && database.getMissingPersons().contains(person.getName()))
                || (database.getTerrorists().contains(person.getIdCode())
                && database.getTerrorists().contains(person.getName()));
    }

    @Override
    public boolean visit(Vehicle vehicle) {
        return database.getStolenVehicles().contains(vehicle.getBorderCrossingId().toString());
    }

    @Override
    public boolean visit(Goods goods) {
        return database.getIllegalGoods().contains(goods.getBorderCrossingId());
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
