package no.ciber.tutorial.spring_hibernate.mapping;

import no.ciber.tutorial.spring_hibernate.domain.Adresse;
import no.ciber.tutorial.spring_hibernate.model.AdresseModel;

public final class AdresseMapper {
    private AdresseMapper() {
    }

    public static Adresse fromAdresseModel(AdresseModel model) {
        return new Adresse(model.getId())
                .postnummer(model.getPostnummer())
                .poststed(model.getPoststed())
                .land(model.getLand())
                .linje1(model.getLinje1())
                .linje2(model.getLinje2())
                .linje3(model.getLinje3());
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
}
