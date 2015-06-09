package no.ciber.tutorial.spring_hibernate.services;

import no.ciber.tutorial.spring_hibernate.domain.Superhero;
import no.ciber.tutorial.spring_hibernate.model.HeroGroup;

import java.util.List;

public interface SuperheroService extends CrudService<Superhero, Long> {
    void delete(long superhero);

    List<Superhero> deleteAllInGroup(HeroGroup group);
}
