package no.ciber.tutorial.spring_hibernate.controllers;

import no.ciber.tutorial.spring_hibernate.domain.Adresse;
import no.ciber.tutorial.spring_hibernate.services.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AdresseController {

    private AdresseService adresseService;

    @Autowired
    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    /**
     * http://localhost/adresse  (GET)
     */
    @RequestMapping(value = "adresse", method = GET)
    public List<Adresse> getAdresser() {
        return adresseService.findAll();
    }

    /**
     * http://localhost/adresse  (POST)
     */
    @RequestMapping(value = "adresse", method = POST)
    public ResponseEntity<Adresse> newAdresse(@RequestBody Adresse adresse) {
        adresseService.create(adresse);
        return new ResponseEntity<Adresse>(HttpStatus.OK);
    }

    /**
     * http://localhost/adresse/{id}
     */
    @RequestMapping(value = "adresse/{id}", method = GET)
    public ResponseEntity<Adresse> getAdresse(@PathVariable String id) {
        Optional<Adresse> adresse = adresseService.findOne(Long.valueOf(id));
        if(adresse.isPresent()){
            return new ResponseEntity<Adresse>(adresse.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Adresse>(HttpStatus.NOT_FOUND);
    }


    public void setAdresseService(AdresseService adresseService) {
        this.adresseService = adresseService;
    }
}
