package no.ciber.tutorial.spring_hibernate.services;

import no.ciber.tutorial.spring_hibernate.domain.Superhero;

import java.util.Optional;

public interface SuperheroService extends CrudService<Superhero, Long> {
    void delete(long superhero);

    Superhero deleteRandom();
}
