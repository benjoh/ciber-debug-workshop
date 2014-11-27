package no.ciber.tutorial.spring_hibernate.mapping;

import no.ciber.tutorial.spring_hibernate.domain.Person;
import no.ciber.tutorial.spring_hibernate.model.PersonModel;

import static no.ciber.tutorial.spring_hibernate.mapping.AdresseMapper.fromAdresseModel;
import static no.ciber.tutorial.spring_hibernate.mapping.AdresseMapper.toAdresseModel;
import static no.ciber.tutorial.spring_hibernate.mapping.KjoretoyMapper.fromKjoretoyModels;
import static no.ciber.tutorial.spring_hibernate.mapping.KjoretoyMapper.toKjoretoyModels;

public final class PersonMapper {
    private PersonMapper() {
    }

    public static Person fromPersonModel(PersonModel model) {
        return new Person(model.getId())
                .fornavn(model.getFornavn())
                .mellomnavn(model.getMellomnavn())
                .etternavn(model.getEtternavn())
                .fodelsdag(model.getFodelsdag())
                .adresse(fromAdresseModel(model.getAdresse()))
                .kjoretoy(fromKjoretoyModels(model.getKjoretoy()));
    }

    public static PersonModel toPersonModel(Person person) {
        PersonModel model = new PersonModel();
        model.setId(person.getId());
        model.setFornavn(person.getFornavn());
        model.setMellomnavn(person.getMellomnavn());
        model.setEtternavn(person.getEtternavn());
        model.setFodelsdag(person.getFodelsdag());
        model.setAdresse(toAdresseModel(person.getAdresse()));
        model.setKjoretoy(toKjoretoyModels(person.getKjoretoy()));
        return model;
    }
}
