package no.ciber.tutorial.spring_hibernate.controllers;

import no.ciber.tutorial.spring_hibernate.domain.Superhero;
import no.ciber.tutorial.spring_hibernate.model.HeroGroup;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CrudHelperController {

    @RequestMapping(value="/superhero/group/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<HeroGroup> getAllGroupAffiliations()  {
        return Arrays.asList(HeroGroup.values());
    }
}
