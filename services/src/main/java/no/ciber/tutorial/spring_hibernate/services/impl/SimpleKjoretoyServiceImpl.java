package no.ciber.tutorial.spring_hibernate.services.impl;

import no.ciber.tutorial.spring_hibernate.domain.Kjoretoy;
import no.ciber.tutorial.spring_hibernate.services.KjoretoyService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

public class SimpleKjoretoyServiceImpl implements KjoretoyService{

    @Override
    public Kjoretoy create(Kjoretoy model) {
        throw new NotImplementedException();
    }

    @Override
    public Optional<Kjoretoy> findOne(String s) {
        throw new NotImplementedException();
    }

    @Override
    public List<Kjoretoy> findAll() {
        throw new NotImplementedException();
    }
}
