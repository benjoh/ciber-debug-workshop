package no.ciber.tutorial.spring_hibernate.config;

import no.ciber.tutorial.spring_hibernate.services.AdresseService;
import no.ciber.tutorial.spring_hibernate.services.KjoretoyService;
import no.ciber.tutorial.spring_hibernate.services.PersonService;
import no.ciber.tutorial.spring_hibernate.services.impl.SimpleAdresseServiceImpl;
import no.ciber.tutorial.spring_hibernate.services.impl.SimpleKjoretoyServiceImpl;
import no.ciber.tutorial.spring_hibernate.services.impl.SimplePersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SimpleServiceConfig {

    @Bean
    public AdresseService adresseService() {
        return new SimpleAdresseServiceImpl();
    }

    @Bean
    public KjoretoyService kjoretoyService() {
        return new SimpleKjoretoyServiceImpl();
    }

    @Bean
    public PersonService personService() {
        return new SimplePersonServiceImpl();
    }
}
