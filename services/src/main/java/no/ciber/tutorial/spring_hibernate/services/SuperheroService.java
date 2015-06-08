package no.ciber.tutorial.spring_hibernate.services;

import no.ciber.tutorial.spring_hibernate.domain.Superhero;

public interface SuperheroService extends CrudService<Superhero, Long> {
    void delete(long superhero);

    Superhero deleteRandom();
}
