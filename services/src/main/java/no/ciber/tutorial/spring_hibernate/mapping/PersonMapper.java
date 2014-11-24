package no.ciber.tutorial.spring_hibernate.mapping;

import no.ciber.tutorial.spring_hibernate.domain.Person;
import no.ciber.tutorial.spring_hibernate.model.PersonModel;

import static no.ciber.tutorial.spring_hibernate.mapping.AdresseMapper.fromAdresseModel;
import static no.ciber.tutorial.spring_hibernate.mapping.AdresseMapper.toAdresseModel;
import static no.ciber.tutorial.spring_hibernate.mapping.KjoretoyMapper.fromKjoretoyModels;
import static no.ciber.tutorial.spring_hibernate.mapping.KjoretoyMapper.toKjoretoyModels;

public final class PersonMapper {
    private PersonMapper(){}

    public static Person fromPersonModel(PersonModel model){
        Person person = new Person();
        person.setId(model.getId());
        person.setFornavn(model.getFornavn());
        person.setMellomnavn(model.getMellomnavn());
        person.setEtternavn(model.getEtternavn());
        person.setFodelsdag(model.getFodelsdag());
        person.setAdresse(fromAdresseModel(model.getAdresse()));
        person.setKjoretoy(fromKjoretoyModels(model.getKjoretoy()));
        return person;
    }

    public static PersonModel toPersonModel(Person person){
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
