package no.ciber.tutorial.spring_hibernate.services.impl;

import no.ciber.tutorial.spring_hibernate.dao.AdresseDAO;
import no.ciber.tutorial.spring_hibernate.domain.Adresse;
import no.ciber.tutorial.spring_hibernate.services.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static no.ciber.tutorial.spring_hibernate.mapping.AdresseMapper.*;

@Service
public class AdresseServiceImpl implements AdresseService {

    private final AdresseDAO adresseDAO;

    @Autowired
    public AdresseServiceImpl(AdresseDAO adresseDAO) {
        this.adresseDAO = adresseDAO;
    }

    @Override
    public Adresse create(Adresse model) {
        return fromAdresseModel(adresseDAO.save(toAdresseModel(model).get())).get();
    }

    @Override
    public Optional<Adresse> findOne(Long id) {
        return fromAdresseModel(adresseDAO.findOne(id));
    }

    @Override
    public List<Adresse> findAll() {
        return fromAdresseModelList(adresseDAO.findAll());
    }
}
