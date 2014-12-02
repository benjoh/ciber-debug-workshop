package no.ciber.tutorial.spring_hibernate.services.impl;

import no.ciber.tutorial.spring_hibernate.dao.PersonDAO;
import no.ciber.tutorial.spring_hibernate.domain.Person;
import no.ciber.tutorial.spring_hibernate.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static no.ciber.tutorial.spring_hibernate.mapping.PersonMapper.*;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;

    @Autowired
    public PersonServiceImpl(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public Person create(Person person) {
        return fromPersonModel(personDAO.save(toPersonModel(person))).get();
    }

    @Override
    public Optional<Person> findOne(Long id) {
        return fromPersonModel(personDAO.findOne(id));
    }

    @Override
    public List<Person> findAll() {
        return fromPersonModelList(personDAO.findAll());
    }
}
