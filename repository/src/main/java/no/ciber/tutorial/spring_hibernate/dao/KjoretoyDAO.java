package no.ciber.tutorial.spring_hibernate.dao;

import no.ciber.tutorial.spring_hibernate.model.KjoretoyModel;
import org.springframework.data.repository.CrudRepository;

public interface KjoretoyDAO extends CrudRepository<KjoretoyModel, String> {
 }