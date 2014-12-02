package no.ciber.tutorial.spring_hibernate.mapping;

import no.ciber.tutorial.spring_hibernate.domain.Kjoretoy;
import no.ciber.tutorial.spring_hibernate.model.KjoretoyModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static no.ciber.tutorial.spring_hibernate.mapping.PersonMapper.fromPersonModel;
import static no.ciber.tutorial.spring_hibernate.mapping.PersonMapper.toPersonModel;

public final class KjoretoyMapper {
    private KjoretoyMapper() {
    }

    public static Optional<Kjoretoy> fromKjoretoyModel(KjoretoyModel model) {
        if(model == null){
            return Optional.empty();
        }
        return Optional.of(new Kjoretoy(model.getUnderstellsnummer())
                .merke(model.getMerke())
                .modell(model.getModell())
                .registreringsnummer(model.getRegistreringsnummer())
                .registreringsaar(model.getRegistreringsaar())
                .eier(model.getEier()));
    }

    public static List<Kjoretoy> fromKjoretoyModels(Iterable<KjoretoyModel> modelList) {
        if(modelList == null){
            return null;
        }
        List<Kjoretoy> kjoretoy = new ArrayList<>();
        modelList.forEach(model -> kjoretoy.add(fromKjoretoyModel(model).get()));
        return kjoretoy;
    }

    public static KjoretoyModel toKjoretoyModel(Kjoretoy kjoretoy) {
        KjoretoyModel model = new KjoretoyModel();
        model.setUnderstellsnummer(kjoretoy.getUnderstellsnummer());
        model.setMerke(kjoretoy.getMerke());
        model.setModell(kjoretoy.getModell());
        model.setRegistreringsnummer(kjoretoy.getRegistreringsnummer());
        model.setRegistreringsaar(kjoretoy.getRegistreringsaar());
        model.setEier(kjoretoy.getEier());
        return model;
    }

    public static List<KjoretoyModel> toKjoretoyModels(List<Kjoretoy> kjoretoyList) {
        if(kjoretoyList == null){
            return null;
        }
        List<KjoretoyModel> models = new ArrayList<>();
        kjoretoyList.forEach(kjoretoy -> models.add(toKjoretoyModel(kjoretoy)));
        return models;
    }
}
