package no.ciber.tutorial.spring_hibernate.services.impl;

import no.ciber.tutorial.spring_hibernate.dao.SuperheroDAO;
import no.ciber.tutorial.spring_hibernate.domain.Superhero;
import no.ciber.tutorial.spring_hibernate.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static no.ciber.tutorial.spring_hibernate.mapping.SuperheroMapper.fromSuperheroModel;
import static no.ciber.tutorial.spring_hibernate.mapping.SuperheroMapper.fromSuperheroModelList;
import static no.ciber.tutorial.spring_hibernate.mapping.SuperheroMapper.toSuperheroModel;

@Service
public class SuperheroServiceImpl implements SuperheroService {
    @Autowired
    private SuperheroDAO superheroDAO;

    @Override
    public Superhero create(Superhero superhero) {
        return fromSuperheroModel(superheroDAO.save(toSuperheroModel(superhero).get())).get();
    }

    @Override
    public Optional<Superhero> findOne(Long aLong) {
        return null;
    }

    @Override
    public List<Superhero> findAll() {
        return fromSuperheroModelList(superheroDAO.findAll());
    }

    @Override
    public void delete(long superheroId) {
        superheroDAO.delete(superheroId);
    }
}
