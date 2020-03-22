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
                .filter(o -> !validator.getDatabase().getTerrorists().contains(o.accept(validator))
                        && !validator.getDatabase().getTerrorists().contains(o.getName())
                        && !validator.getDatabase().getMissingPersons().contains(o.getName())
                        && !validator.getDatabase().getStolenVehicles().contains(o.accept(validator))
                        && !validator.getDatabase().getMissingPersons().contains(o.accept(validator))
                        && !validator.getDatabase().getIllegalGoods().contains(Long.parseLong(o.accept(validator))))
                .collect(Collectors.toList());
    }

    public List<BorderEntity> processBorderCrossersParallel(List<BorderEntity> crossers) {
        return crossers.stream()
                .filter(o -> !validator.getDatabase().getTerrorists().contains(o.accept(validator))
                        && !validator.getDatabase().getTerrorists().contains(o.getName())
                        && !validator.getDatabase().getMissingPersons().contains(o.getName())
                        && !validator.getDatabase().getStolenVehicles().contains(o.accept(validator))
                        && !validator.getDatabase().getMissingPersons().contains(o.accept(validator))
                        && !validator.getDatabase().getIllegalGoods().contains(Long.parseLong(o.accept(validator))))
                .parallel()
                .collect(Collectors.toList());
    }
}
