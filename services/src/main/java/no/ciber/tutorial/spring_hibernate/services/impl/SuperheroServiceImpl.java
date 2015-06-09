package no.ciber.tutorial.spring_hibernate.services.impl;

import no.ciber.tutorial.spring_hibernate.dao.SuperheroDAO;
import no.ciber.tutorial.spring_hibernate.domain.Superhero;
import no.ciber.tutorial.spring_hibernate.model.HeroGroup;
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
    public Superhero save(Superhero superhero) {
        SuperheroModel modelToSave = toSuperheroModel(superhero).get();
        return fromSuperheroModel(superheroDAO.save(modelToSave)).get();
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
    public List<Superhero> deleteAllInGroup(HeroGroup group) {
        List<Superhero> superheros = fromSuperheroModelList(superheroDAO.findAll());
        List<Superhero> heroCopy = new ArrayList<>(superheros);

        for(Superhero hero:superheros){
            if(hero.getGroupAffiliation().equals(group)){
                heroCopy.remove(hero);
                superheroDAO.delete(hero.getId());
            }
        }

        return heroCopy;
    }
}
