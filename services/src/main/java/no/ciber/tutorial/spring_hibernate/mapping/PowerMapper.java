package no.ciber.tutorial.spring_hibernate.mapping;


import no.ciber.tutorial.spring_hibernate.domain.Power;
import no.ciber.tutorial.spring_hibernate.model.PowerModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class PowerMapper {
    public static List<Power> fromPowerModels(List<PowerModel> powerModels) {
        List<Power> powers = new ArrayList<>();
        powerModels.forEach(powerModel -> powers.add(fromPowerModel(powerModel).get()));
        return powers;
    }

    private static Optional<Power> fromPowerModel(PowerModel model) {
        if (model == null) {
            return Optional.empty();
        }
        return Optional.of(new Power(model.getId())
                .shortName(model.getShortName())
                .description(model.getDescription()));
    }

    public static List<PowerModel> toPowerModels(List<Power> superpowers) {
        List<PowerModel> modelList = new ArrayList<>();
        superpowers.forEach(power -> modelList.add(toPowerModel(power).get()));
        return modelList;
    }

    private static Optional<PowerModel> toPowerModel(Power power) {
        if(power == null){
            return Optional.empty();
        }
        PowerModel model = new PowerModel();
        model.setId(power.getId());
        model.setShortName(power.getShortName());
        model.setDescription(power.getDescription());
        return Optional.of(model);
    }
}
