package ee.taltech.iti0200.bordercontrol;

import ee.taltech.iti0200.bordercontrol.database.Database;
import ee.taltech.iti0200.bordercontrol.entity.BorderEntity;

public interface Validator {

    Database getDatabase();

    void setDatabase(Database database);

}
