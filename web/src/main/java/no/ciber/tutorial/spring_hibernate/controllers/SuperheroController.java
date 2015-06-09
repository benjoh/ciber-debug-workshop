package no.ciber.tutorial.spring_hibernate.controllers;

import no.ciber.tutorial.spring_hibernate.domain.Superhero;
import no.ciber.tutorial.spring_hibernate.model.HeroGroup;
import no.ciber.tutorial.spring_hibernate.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        return superheroService.save(superhero);
    }

    @RequestMapping( method = RequestMethod.DELETE)
    public void delete(@RequestParam(value = "id") Long id) {
        superheroService.delete(id);
    }

    @RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Superhero get(@RequestParam(value = "id") long id) {
        Optional<Superhero> one = superheroService.findOne(id);
        return one.get();
    }

/*    @RequestMapping(value="/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Superhero deleteRandomHero()  {
        Superhero deleted = superheroService.deleteRandom();
        return deleted;
    }*/

    @RequestMapping(value="/allInGroup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Superhero> deleteAllInGroup(@RequestParam(value="group") HeroGroup group){
        return superheroService.deleteAllInGroup(group);
    }


}
