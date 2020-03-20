package ee.taltech.iti0200.bordercontrol;

import ee.taltech.iti0200.bordercontrol.entity.BorderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                .filter(o -> !validator.getDatabase().getTerrorists().contains(o.getBorderCrossingId().toString())
                        && !validator.getDatabase().getTerrorists().contains(o.getName())
                        && !validator.getDatabase().getStolenVehicles().contains(o.getBorderCrossingId().toString())
                        && !validator.getDatabase().getMissingPersons().contains(o.getBorderCrossingId().toString())
                        && !validator.getDatabase().getMissingPersons().contains(o.getName())
                        && !validator.getDatabase().getIllegalGoods().contains(o.getBorderCrossingId()))
                .collect(Collectors.toList());
    }

    public List<BorderEntity> processBorderCrossersParallel(List<BorderEntity> crossers) {
        return crossers.stream()
                .filter(o -> !validator.getDatabase().getTerrorists().contains(o.getBorderCrossingId().toString())
                        && !validator.getDatabase().getTerrorists().contains(o.getName())
                        && !validator.getDatabase().getStolenVehicles().contains(o.getBorderCrossingId().toString())
                        && !validator.getDatabase().getMissingPersons().contains(o.getBorderCrossingId().toString())
                        && !validator.getDatabase().getMissingPersons().contains(o.getName())
                        && !validator.getDatabase().getIllegalGoods().contains(o.getBorderCrossingId()))
                .parallel()
                .collect(Collectors.toList());
    }
}
