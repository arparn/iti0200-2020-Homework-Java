package ee.taltech.iti0200.bordercontrol;

import ee.taltech.iti0200.bordercontrol.database.Database;
import ee.taltech.iti0200.bordercontrol.entity.Goods;
import ee.taltech.iti0200.bordercontrol.entity.Person;
import ee.taltech.iti0200.bordercontrol.entity.Vehicle;

public interface Validator {

    String visit(Person person);
    String visit(Vehicle vehicle);
    String visit(Goods goods);

    Database getDatabase();

    void setDatabase(Database database);

}
