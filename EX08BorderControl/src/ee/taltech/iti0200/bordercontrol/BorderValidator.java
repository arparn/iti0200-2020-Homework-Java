package ee.taltech.iti0200.bordercontrol;

import ee.taltech.iti0200.bordercontrol.database.Database;

public class BorderValidator implements Validator {

    Database database;

    public BorderValidator(Database database) {
        this.database = database;
    }
}
