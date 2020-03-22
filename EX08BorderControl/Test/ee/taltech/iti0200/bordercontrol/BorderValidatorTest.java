package ee.taltech.iti0200.bordercontrol;

import ee.taltech.iti0200.bordercontrol.database.DatabaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BorderValidatorTest {

    public static final long NUMBER = 122345678;

    BorderValidator borderValidator;
    DatabaseImpl database;
    List<String> stolenVehicles = new ArrayList<>();
    List<String> missingPersons = new ArrayList<>();
    List<String> terrorists = new ArrayList<>();
    List<Long> illegalGoods = new ArrayList<>();

    @BeforeEach
    void setUp() {
        this.database = new DatabaseImpl();
        stolenVehicles.add("123456778");
        missingPersons.add("123456789");
        terrorists.add("5468604335");
        illegalGoods.add(NUMBER);
        this.borderValidator = new BorderValidator(database);
    }

    @Test
    void getDatabase() {
        database.setIllegalGoods(illegalGoods);
        database.setTerrorists(terrorists);
        database.setMissingPersons(missingPersons);
        database.setStolenVehicles(stolenVehicles);
        assertEquals(database, borderValidator.getDatabase());
    }

    @Test
    void setDatabase() {
        database.setIllegalGoods(illegalGoods);
        database.setTerrorists(terrorists);
        database.setMissingPersons(missingPersons);
        database.setStolenVehicles(stolenVehicles);
        borderValidator.setDatabase(database);
        assertEquals(database, borderValidator.getDatabase());
    }
}
