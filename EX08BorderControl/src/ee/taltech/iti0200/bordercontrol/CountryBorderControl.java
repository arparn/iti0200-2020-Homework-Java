package ee.taltech.iti0200.bordercontrol;

import ee.taltech.iti0200.bordercontrol.entity.BorderEntity;

import java.util.List;

public class CountryBorderControl {

    String country;
    String borderName;
    Validator validator;

    public CountryBorderControl(String country, String borderName, Validator validator) {
        this.validator = validator;
        this.borderName = borderName;
        this.country = country;
    }

    public List<BorderEntity> processBorderCrossers(List<BorderEntity> crossers) {
        return null;
    }

    public List<BorderEntity> processBorderCrossersParallel(List<BorderEntity> crossers) {
        return null;
    }
}
