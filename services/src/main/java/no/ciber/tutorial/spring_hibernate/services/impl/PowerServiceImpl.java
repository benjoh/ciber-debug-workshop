package no.ciber.tutorial.spring_hibernate.services.impl;

import no.ciber.tutorial.spring_hibernate.dao.PowerDAO;
import no.ciber.tutorial.spring_hibernate.domain.Power;
import no.ciber.tutorial.spring_hibernate.services.PowerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PowerServiceImpl implements PowerService {
    @Autowired
    PowerDAO powerDAO;

    @Override
    public Power create(Power model) {
        return null;
    }

    @Override
    public Power save(Power model) {
        return null;
    }

    @Override
    public Optional<Power> findOne(Long aLong) {
        return null;
    }

    @Override
    public List<Power> findAll() {
        return null;
    }
}
