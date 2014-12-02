package no.ciber.tutorial.spring_hibernate.mapping;

import no.ciber.tutorial.spring_hibernate.domain.Person;
import no.ciber.tutorial.spring_hibernate.model.PersonModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static no.ciber.tutorial.spring_hibernate.mapping.AdresseMapper.fromAdresseModel;
import static no.ciber.tutorial.spring_hibernate.mapping.AdresseMapper.toAdresseModel;
import static no.ciber.tutorial.spring_hibernate.mapping.KjoretoyMapper.fromKjoretoyModels;
import static no.ciber.tutorial.spring_hibernate.mapping.KjoretoyMapper.toKjoretoyModels;

public final class PersonMapper {
    private PersonMapper() {
    }

    public static Optional<Person> fromPersonModel(PersonModel model) {
        if(model == null){
            return Optional.empty();
        }
        return Optional.of(new Person(model.getId())
                .fornavn(model.getFornavn())
                .mellomnavn(model.getMellomnavn())
                .etternavn(model.getEtternavn())
                .fodelsdag(model.getFodelsdag())
                .adresse(fromAdresseModel(model.getAdresse()).orElse(null))
                .kjoretoy(fromKjoretoyModels(model.getKjoretoy())));
    }

    public static List<Person> fromPersonModelList(Iterable<PersonModel> personModels){
        List<Person> personer = new ArrayList<>();
        personModels.forEach(personModel -> personer.add(fromPersonModel(personModel).get()));
        return personer;
    }

    public static PersonModel toPersonModel(Person person) {
        if(person == null){
            return null;
        }
        PersonModel model = new PersonModel();
        model.setId(person.getId());
        model.setFornavn(person.getFornavn());
        model.setMellomnavn(person.getMellomnavn());
        model.setEtternavn(person.getEtternavn());
        model.setFodelsdag(person.getFodelsdag());
        model.setAdresse(toAdresseModel(person.getAdresse()).orElse(null));
        model.setKjoretoy(toKjoretoyModels(person.getKjoretoy()));
        return model;
    }

    public static List<PersonModel> toPersonModelList(List<Person> personer){
        List<PersonModel> personModels = new ArrayList<>();
        personer.forEach(person -> personModels.add(toPersonModel(person)));
        return personModels;
    }
}
