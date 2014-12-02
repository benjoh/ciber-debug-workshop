package no.ciber.tutorial.spring_hibernate.services.impl;

import no.ciber.tutorial.spring_hibernate.dao.KjoretoyDAO;
import no.ciber.tutorial.spring_hibernate.domain.Kjoretoy;
import no.ciber.tutorial.spring_hibernate.mapping.KjoretoyMapper;
import no.ciber.tutorial.spring_hibernate.services.KjoretoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static no.ciber.tutorial.spring_hibernate.mapping.KjoretoyMapper.fromKjoretoyModel;
import static no.ciber.tutorial.spring_hibernate.mapping.KjoretoyMapper.toKjoretoyModel;

@Service
public class KjoretoyServiceImpl implements KjoretoyService {

    private final KjoretoyDAO kjoretoyDAO;

    @Autowired
    public KjoretoyServiceImpl(KjoretoyDAO kjoretoyDAO) {
        this.kjoretoyDAO = kjoretoyDAO;
    }

    @Override
    public Kjoretoy create(Kjoretoy kjoretoy) {
        return fromKjoretoyModel(kjoretoyDAO.save(toKjoretoyModel(kjoretoy))).get();
    }

    @Override
    public Optional<Kjoretoy> findOne(String id) {
        return KjoretoyMapper.fromKjoretoyModel(kjoretoyDAO.findOne(id));
    }

    @Override
    public List<Kjoretoy> findAll() {
        return KjoretoyMapper.fromKjoretoyModels(kjoretoyDAO.findAll());
    }
}
