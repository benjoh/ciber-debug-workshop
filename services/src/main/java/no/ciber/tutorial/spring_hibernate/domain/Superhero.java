package no.ciber.tutorial.spring_hibernate.domain;

import no.ciber.tutorial.spring_hibernate.model.HeroGroup;

import java.util.List;

public class Superhero implements Comparable<Superhero> {
    private Long id;
    private String heroName;
    private String realName;
    private int height;
    private List<Power> superpowers;
    private List<Movie> movieAppearances;
    private HeroGroup groupAffiliation;
    private String imageUrl;

    public Superhero(){}

    public Superhero(Long id) {
        this.id = id;
    }

    public Superhero name(String name) {
        Superhero hero = copy();
        hero.heroName = name;
        return hero;
    }

    public Superhero imageUrl(String imageUrl) {
        Superhero hero = copy();
        hero.imageUrl = imageUrl;
        return hero;
    }

    public Superhero realName(String realName) {
        Superhero hero = copy();
        hero.realName = realName;
        return hero;
    }

    public Superhero height(int height) {
        Superhero hero = copy();
        hero.height = height;
        return hero;
    }

    public Superhero movieAppearances(List<Movie> appearances) {
        Superhero hero = copy();
        hero.movieAppearances = appearances;
        return hero;
    }

    public Superhero powers(List<Power> powers) {
        Superhero hero = copy();
        hero.superpowers = powers;
        return hero;
    }

    public Superhero group(HeroGroup group) {
        Superhero hero = copy();
        hero.groupAffiliation = group;
        return hero;
    }

    final Superhero copy() {
        Superhero hero = new Superhero(getId());
        hero.heroName = getHeroName();
        hero.realName = getRealName();
        hero.imageUrl = getImageUrl();
        hero.height = getHeight();
        hero.movieAppearances = getMovieAppearances();
        hero.superpowers = getSuperpowers();
        hero.groupAffiliation = getGroupAffiliation();
        return hero;

    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public HeroGroup getGroupAffiliation() {
        return groupAffiliation;
    }

    public void setGroupAffiliation(HeroGroup groupAffiliation) {
        this.groupAffiliation = groupAffiliation;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public int compareTo(Superhero o) {
        return this.heroName.compareTo(o.getHeroName());
    }

    public List<Movie> getMovieAppearances() {
        return movieAppearances;
    }

    public List<Power> getSuperpowers() {
        return superpowers;
    }

    public void setSuperpowers(List<Power> superpowers) {
        this.superpowers = superpowers;
    }
}
