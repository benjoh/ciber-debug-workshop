package no.ciber.tutorial.spring_hibernate.services.impl;

import no.ciber.tutorial.spring_hibernate.dao.SuperheroDAO;
import no.ciber.tutorial.spring_hibernate.domain.Superhero;
import no.ciber.tutorial.spring_hibernate.model.SuperheroModel;
import no.ciber.tutorial.spring_hibernate.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public Superhero deleteRandom() {
        List<Superhero> superheros = fromSuperheroModelList(superheroDAO.findAll());
        int max = superheros.size();
        int theOne = new Random().nextInt((max-1)+1);
        int current = 1;

        for(Superhero hero : superheros){
            if(current == theOne){
                superheros.remove(hero);
                superheroDAO.delete(hero.getId());
                return hero;
            }
            current++;
        }

        return superheros.get(0);
    }
}
