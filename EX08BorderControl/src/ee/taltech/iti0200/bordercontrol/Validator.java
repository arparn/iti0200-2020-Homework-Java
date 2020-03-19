package ee.taltech.iti0200.bordercontrol;

import ee.taltech.iti0200.bordercontrol.database.Database;
import ee.taltech.iti0200.bordercontrol.entity.BorderEntity;

public interface Validator {
    void accept(BorderCrosserVisitor visitor);
}

interface BorderCrosserVisitor {
    void visit(Database database);
}
