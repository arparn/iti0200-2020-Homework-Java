package ee.taltech.iti0200.bordercontrol.database;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DatabaseImpl  implements Database{

    List<String> stolenVehicles = new ArrayList<>();
    List<String> missingPeople = new ArrayList<>();
    List<String> terrorists = new ArrayList<>();
    List<String> illegalGoods = new ArrayList<>();

    @Override
    public List<String> getStolenVehicles() {
        return this.stolenVehicles;
    }

    @Override
    public List<String> getMissingPersons() {
        return this.missingPeople;
    }

    @Override
    public List<String> getTerrorists() {
        return this.terrorists;
    }

    @Override
    public List<String> getIllegalGoods() {
        return this.illegalGoods;
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
        illegalGoods = (List<String>) Stream.of(newIllegalGoods).map(good -> String.valueOf(good));
    }
}
