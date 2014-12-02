package no.ciber.tutorial.spring_hibernate.dao;

import no.ciber.tutorial.spring_hibernate.model.AdresseModel;

public interface AdresseDAO {
    AdresseModel save(AdresseModel adresseModel);

    AdresseModel findOne(Long id);

    Iterable<AdresseModel> findAll();
}
/**
 public interface AdresseDAO extends CrudRepository<AdresseModel, Long> {
 }
 */
