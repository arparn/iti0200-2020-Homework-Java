package ee.taltech.iti0200.steakhouse;

import ee.taltech.iti0200.steakhouse.steak.SteakType;
import ee.taltech.iti0200.steakhouse.strategy.CookStrategy;

public class Order {

    private SteakType steakType;
    private CookStrategy cookStrategy;

    public Order(SteakType steakType, CookStrategy cookStrategy) {
        this.steakType = steakType;
        this.cookStrategy = cookStrategy;
    }

    public void setSteakType(SteakType newSteakType) {
        steakType = newSteakType;
    }

    public void setCookStrategy(CookStrategy newCookStrategy) {
        cookStrategy = newCookStrategy;
    }

    public SteakType getSteakType() {
        return steakType;
    }

    public CookStrategy getCookStrategy() {
        return cookStrategy;
    }
}
