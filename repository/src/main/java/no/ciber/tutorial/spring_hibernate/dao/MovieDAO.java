package no.ciber.tutorial.spring_hibernate.dao;

import no.ciber.tutorial.spring_hibernate.model.MovieModel;
import org.springframework.data.repository.CrudRepository;

public interface MovieDAO extends CrudRepository<MovieModel, Long> {
}
