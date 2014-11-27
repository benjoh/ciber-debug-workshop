package no.ciber.tutorial.spring_hibernate.controllers;

import no.ciber.tutorial.spring_hibernate.services.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
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
    @ResponseBody
    public String getAdresser() {
        return adresseService.getAdresser().toString();
    }

    /**
     * http://localhost/adresse/{id}
     */
    @RequestMapping(value = "adresse/{id}", method = GET)
    @ResponseBody
    public String getAdresse(@PathVariable String id) {
        return adresseService.getAdresse(Long.valueOf(id)).toString();
    }


    public void setAdresseService(AdresseService adresseService) {
        this.adresseService = adresseService;
    }
}
