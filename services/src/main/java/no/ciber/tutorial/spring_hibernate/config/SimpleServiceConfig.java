package no.ciber.tutorial.spring_hibernate.config;

import no.ciber.tutorial.spring_hibernate.services.AdresseService;
import no.ciber.tutorial.spring_hibernate.services.KjoretoyService;
import no.ciber.tutorial.spring_hibernate.services.PersonService;
import no.ciber.tutorial.spring_hibernate.services.impl.SimpleAdresseServiceImpl;
import no.ciber.tutorial.spring_hibernate.services.impl.SimpleKjoretoyServiceImpl;
import no.ciber.tutorial.spring_hibernate.services.impl.SimplePersonServiceImpl;

public class SimpleServiceConfig {

    public AdresseService initAdresseService() {
        return new SimpleAdresseServiceImpl();
    }

    public KjoretoyService initKjoretoyService() {
        return new SimpleKjoretoyServiceImpl();
    }

    public PersonService initPersonService() {
        return new SimplePersonServiceImpl();
    }
}
