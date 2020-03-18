package ee.taltech.iti0200.steakhouse.strategy;

import ee.taltech.iti0200.steakhouse.steak.SteakType;

public class CookWell implements CookStrategy {
    @Override
    public double calculateWeightLoss(String cookName, SteakType steakType) {
        return (steakType.getWeight() * (double) 20) / 100;
    }
}
