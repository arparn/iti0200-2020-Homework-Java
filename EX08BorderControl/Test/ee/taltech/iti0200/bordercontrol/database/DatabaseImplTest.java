package ee.taltech.iti0200.bordercontrol.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseImplTest {

    DatabaseImpl database;
    List<String> stolenVehicles = new ArrayList<>();
    List<String> missingPersons = new ArrayList<>();
    List<String> terrorists = new ArrayList<>();
    List<Long> illegalGoods = new ArrayList<>();

    @BeforeEach
    void setUp() {
        this.database = new DatabaseImpl();
        stolenVehicles.add("asd12345");
        stolenVehicles.add("sdd54321");
        missingPersons.add("5000345637");
        missingPersons.add("3456789007");
        terrorists.add("234567878");
        illegalGoods.add((long) 2345678);
    }

    @Test
    void getStolenVehicles() {
        database.setStolenVehicles(stolenVehicles);
        assertEquals(stolenVehicles, database.getStolenVehicles());
    }

    @Test
    void getMissingPersons() {
        database.setMissingPersons(missingPersons);
        assertEquals(missingPersons, database.getMissingPersons());
    }

    @Test
    void getTerrorists() {
        database.setTerrorists(terrorists);
        assertEquals(terrorists, database.getTerrorists());
    }

    @Test
    void getIllegalGoods() {
        database.setIllegalGoods(illegalGoods);
        assertEquals(illegalGoods, database.getIllegalGoods());
    }

    @Test
    void setStolenVehicles() {
        stolenVehicles.add("fgh546378");
        database.setStolenVehicles(stolenVehicles);
        assertEquals(stolenVehicles, database.getStolenVehicles());
    }

    @Test
    void setMissingPersons() {
        missingPersons.add("3456678904");
        database.setMissingPersons(missingPersons);
        assertEquals(missingPersons, database.getMissingPersons());
    }

    @Test
    void setTerrorists() {
        terrorists.add("hghvhgujvnvh");
        database.setTerrorists(terrorists);
        assertEquals(terrorists, database.getTerrorists());
    }

    @Test
    void setIllegalGoods() {
        illegalGoods.add((long) 123445679);
        database.setIllegalGoods(illegalGoods);
        assertEquals(illegalGoods, database.getIllegalGoods());
    }
}