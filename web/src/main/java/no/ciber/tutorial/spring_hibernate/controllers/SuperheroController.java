package no.ciber.tutorial.spring_hibernate.controllers;

import no.ciber.tutorial.spring_hibernate.domain.Superhero;
import no.ciber.tutorial.spring_hibernate.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crud/superhero")
public class SuperheroController {

    @Autowired
    SuperheroService superheroService;

    @RequestMapping(value="/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<Superhero> getAllHeroes()  {
        return superheroService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Superhero save(@RequestParam(value = "id", required = false) Long id, @RequestBody Superhero superhero) throws Exception {
        return superheroService.create(superhero);
    }

    @RequestMapping( method = RequestMethod.DELETE)
    public void delete(@RequestParam(value = "id") Long id) {
        superheroService.delete(id);
    }

}
