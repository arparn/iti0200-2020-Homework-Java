package ee.taltech.iti0200.steakhouse.strategy;

import ee.taltech.iti0200.steakhouse.steak.SteakType;

public class CookMedium implements CookStrategy {
    @Override
    public double calculateWeightLoss(String cookName, SteakType steakType) {
        return (steakType.getWeight() * (double) cookName.length()) / 100;
    }
}
