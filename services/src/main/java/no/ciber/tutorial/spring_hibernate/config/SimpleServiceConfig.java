package no.ciber.tutorial.spring_hibernate.config;

import no.ciber.tutorial.spring_hibernate.services.AdresseService;
import no.ciber.tutorial.spring_hibernate.services.impl.SimpleAdresseServiceImpl;
import org.springframework.context.annotation.Bean;

//@Configuration
public class SimpleServiceConfig {

    @Bean
    public AdresseService adresseService() {
        return new SimpleAdresseServiceImpl();
    }
}
