package ee.taltech.iti0200.bordercontrol;

import ee.taltech.iti0200.bordercontrol.entity.BorderEntity;

import java.util.List;
import java.util.stream.Collectors;

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
        return crossers.stream()
                .filter(o -> !o.accept(validator))
                .collect(Collectors.toList());
    }

    public List<BorderEntity> processBorderCrossersParallel(List<BorderEntity> crossers) {
        return crossers.parallelStream()
                .filter(o -> !o.accept(validator))
                .collect(Collectors.toList());
    }
}
