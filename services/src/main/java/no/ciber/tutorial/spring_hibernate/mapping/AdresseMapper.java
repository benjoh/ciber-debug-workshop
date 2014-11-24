package no.ciber.tutorial.spring_hibernate.mapping;

import no.ciber.tutorial.spring_hibernate.domain.Adresse;
import no.ciber.tutorial.spring_hibernate.model.AdresseModel;

public final class AdresseMapper {
    private AdresseMapper(){
    }

    public static Adresse fromAdresseModel(AdresseModel model){
        Adresse adresse = new Adresse();
        adresse.setPostnummer(model.getPostnummer());
        adresse.setPoststed(model.getPoststed());
        adresse.setLand(model.getLand());
        adresse.setLinje1(model.getLinje1());
        adresse.setLinje2(model.getLinje2());
        adresse.setLinje3(model.getLinje3());
        adresse.setId(model.getId());
        return adresse;
    }

    public static AdresseModel toAdresseModel(Adresse adresse){
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
