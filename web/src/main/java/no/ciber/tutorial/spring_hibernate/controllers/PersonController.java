package no.ciber.tutorial.spring_hibernate.controllers;

import no.ciber.tutorial.spring_hibernate.domain.Adresse;
import no.ciber.tutorial.spring_hibernate.domain.Person;
import no.ciber.tutorial.spring_hibernate.services.AdresseService;
import no.ciber.tutorial.spring_hibernate.services.PersonService;
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

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * http://localhost/person  (GET)
     */
    @RequestMapping(value = "person", method = GET)
    public List<Person> getPersoner() {
        return personService.findAll();
    }

    /**
     * http://localhost/person  (POST)
     */
    @RequestMapping(value = "person", method = POST)
    public ResponseEntity<Adresse> newPerson(@RequestBody Person person) {
        personService.create(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * http://localhost/person/{id}
     */
    @RequestMapping(value = "person/{id}", method = GET)
    public ResponseEntity<Person> getPerson(@PathVariable String id) {
        Optional<Person> person = personService.findOne(Long.valueOf(id));
        if(person.isPresent()){
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
