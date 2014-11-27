package no.ciber.tutorial.spring_hibernate.controllers;

import no.ciber.tutorial.spring_hibernate.domain.Adresse;
import no.ciber.tutorial.spring_hibernate.services.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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
        return adresseService.getAdresser();
    }

    /**
     * http://localhost/adresse/{id}
     */
    @RequestMapping(value = "adresse/{id}", method = GET)
    public Adresse getAdresse(@PathVariable String id) {
        return adresseService.getAdresse(Long.valueOf(id));
    }


    public void setAdresseService(AdresseService adresseService) {
        this.adresseService = adresseService;
    }
}
