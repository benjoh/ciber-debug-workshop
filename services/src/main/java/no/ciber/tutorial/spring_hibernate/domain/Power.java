package no.ciber.tutorial.spring_hibernate.domain;

import java.util.List;

public class Power {
    private Long id;
    private String shortName;
    private String description;
    private List<Superhero> heroes;

    public Power(){}
    public Power(Long id) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Superhero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Superhero> heroes) {
        this.heroes = heroes;
    }

    public Power shortName(String shortName) {
        Power power = copy();
        power.shortName = shortName;
        return power;
    }

    private Power copy() {
        Power power = new Power(getId());
        power.shortName = getShortName();
        power.description = getDescription();
        return power;
    }

    public Power description(String description) {
        Power power = copy();
        power.description = description;
        return power;
    }
}
