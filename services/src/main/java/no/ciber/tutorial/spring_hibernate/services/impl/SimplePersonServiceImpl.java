package no.ciber.tutorial.spring_hibernate.services.impl;

import no.ciber.tutorial.spring_hibernate.domain.Person;
import no.ciber.tutorial.spring_hibernate.services.PersonService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

public class SimplePersonServiceImpl implements PersonService {

    @Override
    public Person create(Person model) {
        throw new NotImplementedException();
    }

    @Override
    public Optional<Person> findOne(Long aLong) {
        throw new NotImplementedException();
    }

    @Override
    public List<Person> findAll() {
        throw new NotImplementedException();
    }
}
