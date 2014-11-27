package no.ciber.tutorial.spring_hibernate.controllers;

import no.ciber.tutorial.spring_hibernate.services.AdresseService;
import no.ciber.tutorial.spring_hibernate.services.impl.SimpleAdresseServiceImpl;
import org.springframework.web.bind.annotation.ResponseBody;

public class AdresseController {

    private AdresseService adresseService;

    public AdresseController(SimpleAdresseServiceImpl adresseService) {
        this.adresseService = adresseService;
    }

    /**
     * http://localhost/adresse  (GET)
     */
    @ResponseBody
    public String getAdresser(){
        return "Hent alle adresser";
    }

    /**
     * http://localhost/adresse/{id}
     */
    public String getAdresse(String id){
        return "Hent spesifikk adresse";
    }


    public void setAdresseService(AdresseService adresseService) {
        this.adresseService = adresseService;
    }
}
