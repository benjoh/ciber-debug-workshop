package no.ciber.tutorial.spring_hibernate.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"no.ciber.tutorial.spring_hibernate.services"})
public class ServiceConfig {

}
