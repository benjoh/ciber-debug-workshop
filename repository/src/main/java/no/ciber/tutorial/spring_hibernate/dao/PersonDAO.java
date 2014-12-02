package no.ciber.tutorial.spring_hibernate.dao;


import no.ciber.tutorial.spring_hibernate.model.PersonModel;

public interface PersonDAO {
    PersonModel save(PersonModel personModel);

    PersonModel findOne(Long id);

    Iterable<PersonModel> findAll();
}

/**
 public interface PersonDAO extends CrudRepository<PersonModel, Long> {
 }
 */
