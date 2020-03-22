package ee.taltech.iti0200.bordercontrol;

import ee.taltech.iti0200.bordercontrol.database.DatabaseImpl;
import ee.taltech.iti0200.bordercontrol.entity.BorderEntity;
import ee.taltech.iti0200.bordercontrol.entity.Goods;
import ee.taltech.iti0200.bordercontrol.entity.Person;
import ee.taltech.iti0200.bordercontrol.entity.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountryBorderControlTest {

    CountryBorderControl borderControl;
    Validator validator;
    DatabaseImpl database;
    List<String> stolenVehicles = new ArrayList<>();
    List<String> missingPersons = new ArrayList<>();
    List<String> terrorists = new ArrayList<>();
    List<Long> illegalGoods = new ArrayList<>();
    List<BorderEntity> crossers = new ArrayList<>();
    Vehicle vehicle;
    Person person;
    Goods item;

    @BeforeEach
    void setUp() {
        this.database = new DatabaseImpl();
        stolenVehicles.add("123456778");
        missingPersons.add("123456789");
        terrorists.add("5468604335");
        illegalGoods.add((long) 12234578);
        database.setIllegalGoods(illegalGoods);
        database.setTerrorists(terrorists);
        database.setMissingPersons(missingPersons);
        database.setStolenVehicles(stolenVehicles);
        this.validator = new BorderValidator(database);
        this.borderControl = new CountryBorderControl("Estonia", "Narva", validator);
        this.vehicle = new Vehicle("12345677");
        this.person = new Person("Martin", "5468202648");
        this.item = new Goods((long) 122345678);
    }

    @Test
    void processBorderCrossers() {
        crossers.add(vehicle);
        crossers.add(person);
        crossers.add(item);
        assertEquals(crossers, borderControl.processBorderCrossers(crossers));
    }

    @Test
    void processBorderCrossersParallel() {
        crossers.add(vehicle);
        crossers.add(person);
        assertEquals(crossers, borderControl.processBorderCrossersParallel(crossers));
    }
}
