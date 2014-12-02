package no.ciber.tutorial.spring_hibernate.services;

import no.ciber.tutorial.spring_hibernate.domain.Adresse;

import java.util.List;

public interface AdresseService {
    public java.util.Optional<Adresse> getAdresse(Long id);

    public List<Adresse> getAdresser();

    public java.util.Optional<Adresse> save(Adresse adresse);
}
