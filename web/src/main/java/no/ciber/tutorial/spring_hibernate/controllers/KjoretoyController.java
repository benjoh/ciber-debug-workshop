package no.ciber.tutorial.spring_hibernate.controllers;

import no.ciber.tutorial.spring_hibernate.domain.Kjoretoy;
import no.ciber.tutorial.spring_hibernate.services.KjoretoyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

public class KjoretoyController {

    private KjoretoyService kjoretoyService;

    public KjoretoyController(KjoretoyService kjoretoyService) {
        this.kjoretoyService = kjoretoyService;
    }

    /**
     * http://localhost/kjoretoy  (GET)
     */
    public List<Kjoretoy> getKjoretoroy() {
        return kjoretoyService.findAll();
    }

    /**
     * http://localhost/kjoretoy  (POST)
     */
    public ResponseEntity<Kjoretoy> newAdresse(@RequestBody Kjoretoy kjoretoy) {
        kjoretoyService.create(kjoretoy);
        return new ResponseEntity<Kjoretoy>(HttpStatus.OK);
    }

    /**
     * http://localhost/kjoretoy/{id}
     */
    public ResponseEntity<Kjoretoy> getKjoretoy(@PathVariable String id) {
        Optional<Kjoretoy> kjoretoy = kjoretoyService.findOne(id);
        if (kjoretoy.isPresent()) {
            return new ResponseEntity<Kjoretoy>(kjoretoy.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Kjoretoy>(HttpStatus.NOT_FOUND);
    }


    public void setKjoretoyService(KjoretoyService kjoretoyService) {
        this.kjoretoyService = kjoretoyService;
    }
}
