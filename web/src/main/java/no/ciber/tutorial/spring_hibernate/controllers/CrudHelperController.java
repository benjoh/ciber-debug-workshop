package no.ciber.tutorial.spring_hibernate.controllers;

import no.ciber.tutorial.spring_hibernate.domain.Movie;
import no.ciber.tutorial.spring_hibernate.model.HeroGroup;
import no.ciber.tutorial.spring_hibernate.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CrudHelperController {
    @Autowired
    MovieService movieService;

    @RequestMapping(value="/superhero/group/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<HeroGroup> getAllGroupAffiliations()  {

        HeroGroup[] values = HeroGroup.values();

        return Arrays.asList(HeroGroup.values());
    }

    @RequestMapping(value="/superhero/movies/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Movie> getAllMovies()  {
        return movieService.findAll();
    }
}
