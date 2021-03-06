package ee.taltech.iti0200.steakhouse.strategy;

import ee.taltech.iti0200.steakhouse.steak.SteakType;

public class CookWell implements CookStrategy {

    public static final int PERCENTAGE = 20;

    @Override
    public double calculateWeightLoss(String cookName, SteakType steakType) {
        return (steakType.getWeight() * (double) PERCENTAGE) / 100;
    }
}
