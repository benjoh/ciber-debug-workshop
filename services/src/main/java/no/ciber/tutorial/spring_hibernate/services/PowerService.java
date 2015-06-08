package no.ciber.tutorial.spring_hibernate.services;

import no.ciber.tutorial.spring_hibernate.domain.Power;
import org.springframework.stereotype.Service;

@Service
public interface PowerService extends CrudService<Power, Long> {
}
