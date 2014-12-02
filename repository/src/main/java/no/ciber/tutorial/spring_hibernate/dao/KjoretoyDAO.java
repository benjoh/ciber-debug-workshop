package no.ciber.tutorial.spring_hibernate.dao;

import no.ciber.tutorial.spring_hibernate.model.KjoretoyModel;

public interface KjoretoyDAO {
    KjoretoyModel save(KjoretoyModel kjoretoyModel);

    KjoretoyModel findOne(String id);

    Iterable<KjoretoyModel> findAll();
}

/**
 public interface KjoretoyDAO extends CrudRepository<KjoretoyModel, String> {
 }
 */
