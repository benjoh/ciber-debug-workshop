package no.ciber.tutorial.spring_hibernate.services.impl;

import no.ciber.tutorial.spring_hibernate.dao.SuperheroDAO;
import no.ciber.tutorial.spring_hibernate.domain.Superhero;
import no.ciber.tutorial.spring_hibernate.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static no.ciber.tutorial.spring_hibernate.mapping.SuperheroMapper.*;

@Service
public class SuperheroServiceImpl implements SuperheroService {
    @Autowired
    private SuperheroDAO superheroDAO;

    @Override
    public Superhero create(Superhero superhero) {
        return fromSuperheroModel(superheroDAO.save(toSuperheroModel(superhero).get())).get();
    }

    @Override
    public Superhero save(Superhero superhero) {
        return fromSuperheroModel(superheroDAO.save(toSuperheroModel(superhero).get())).get();
    }

    @Override
    public Optional<Superhero> findOne(Long id) {
        return fromSuperheroModel(superheroDAO.findOne(id));
    }

    @Override
    public List<Superhero> findAll() {
        List<Superhero> superheros = fromSuperheroModelList(superheroDAO.findAll());
        Collections.sort(superheros);
        return superheros;
    }

    @Override
    public void delete(long superheroId) {
        superheroDAO.delete(superheroId);
    }
}
