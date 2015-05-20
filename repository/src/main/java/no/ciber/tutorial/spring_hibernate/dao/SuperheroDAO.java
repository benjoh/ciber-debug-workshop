package no.ciber.tutorial.spring_hibernate.dao;

import no.ciber.tutorial.spring_hibernate.model.SuperheroModel;
import org.springframework.data.repository.CrudRepository;

public interface SuperheroDAO extends CrudRepository<SuperheroModel, Long> {
}
