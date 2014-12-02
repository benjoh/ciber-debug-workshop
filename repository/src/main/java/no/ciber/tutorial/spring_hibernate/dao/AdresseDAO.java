package no.ciber.tutorial.spring_hibernate.dao;

import no.ciber.tutorial.spring_hibernate.model.AdresseModel;
import org.springframework.data.repository.CrudRepository;

public interface AdresseDAO extends CrudRepository<AdresseModel, Long> {
}
