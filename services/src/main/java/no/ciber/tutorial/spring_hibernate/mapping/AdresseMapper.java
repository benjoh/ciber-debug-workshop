package no.ciber.tutorial.spring_hibernate.mapping;

import no.ciber.tutorial.spring_hibernate.domain.Adresse;
import no.ciber.tutorial.spring_hibernate.model.AdresseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class AdresseMapper {
    private AdresseMapper() {
    }

    public static Optional<Adresse> fromAdresseModel(AdresseModel model) {
        if (model == null) {
            return Optional.empty();
        }
        return Optional.of(new Adresse(model.getId())
                .postnummer(model.getPostnummer())
                .poststed(model.getPoststed())
                .land(model.getLand())
                .linje1(model.getLinje1())
                .linje2(model.getLinje2())
                .linje3(model.getLinje3()));
    }

    public static List<Adresse> fromAdresseModelList(Iterable<AdresseModel> modelList) {
        List<Adresse> adresser = new ArrayList<>();
        modelList.forEach(adresseModel -> adresser.add(fromAdresseModel(adresseModel).get()));
        return adresser;
    }

    public static AdresseModel toAdresseModel(Adresse adresse) {
        AdresseModel model = new AdresseModel();
        model.setPostnummer(adresse.getPostnummer());
        model.setPoststed(adresse.getPoststed());
        model.setLand(adresse.getLand());
        model.setLinje1(adresse.getLinje1());
        model.setLinje2(adresse.getLinje2());
        model.setLinje3(adresse.getLinje3());
        model.setId(adresse.getId());
        return model;

    }

    public static List<AdresseModel> toAdresseModelList(List<Adresse> adresser) {
        List<AdresseModel> modelList = new ArrayList<>();
        adresser.forEach(adresse -> modelList.add(toAdresseModel(adresse)));
        return modelList;
    }
}
