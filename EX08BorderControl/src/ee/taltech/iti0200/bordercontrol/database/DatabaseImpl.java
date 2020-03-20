package ee.taltech.iti0200.bordercontrol.database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DatabaseImpl implements Database {

    List<String> stolenVehicles = new ArrayList<>();
    List<String> missingPeople = new ArrayList<>();
    List<String> terrorists = new ArrayList<>();
    List<Long> illegalGoods = new ArrayList<>();

    @Override
    public List<String> getStolenVehicles() {
        return stolenVehicles;
    }

    @Override
    public List<String> getMissingPersons() {
        return missingPeople;
    }

    @Override
    public List<String> getTerrorists() {
        return terrorists;
    }

    @Override
    public List<Long> getIllegalGoods() {
        return illegalGoods;
    }

    @Override
    public void setStolenVehicles(List<String> newStolenVehicles) {
        stolenVehicles = newStolenVehicles;
    }

    @Override
    public void setMissingPersons(List<String> newMissingPersons) {
        missingPeople = newMissingPersons;
    }

    @Override
    public void setTerrorists(List<String> newTerrorists) {
        terrorists = newTerrorists;
    }

    @Override
    public void setIllegalGoods(List<Long> newIllegalGoods) {
        illegalGoods = newIllegalGoods;
    }
}
