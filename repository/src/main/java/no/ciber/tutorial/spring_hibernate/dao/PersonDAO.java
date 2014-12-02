package no.ciber.tutorial.spring_hibernate.dao;


import no.ciber.tutorial.spring_hibernate.model.PersonModel;
import org.springframework.data.repository.CrudRepository;

public interface PersonDAO extends CrudRepository<PersonModel, Long> {
}
