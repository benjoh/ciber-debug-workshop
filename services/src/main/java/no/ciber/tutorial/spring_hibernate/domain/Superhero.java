package no.ciber.tutorial.spring_hibernate.domain;

import no.ciber.tutorial.spring_hibernate.model.HeroGroup;

public class Superhero implements Comparable<Superhero> {
    private Long id;
    private String heroName;
    private String realName;
    private int height;
    private String appearanceComic;
    private String appearanceMovie;
    private String powers;
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

    public Superhero firstComic(String firstComic) {
        Superhero hero = copy();
        hero.appearanceComic = firstComic;
        return hero;
    }

    public Superhero firstMovie(String firstMovie) {
        Superhero hero = copy();
        hero.appearanceMovie = firstMovie;
        return hero;
    }

    public Superhero abilities(String abilities) {
        Superhero hero = copy();
        hero.powers = abilities;
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
        hero.appearanceComic = getAppearanceComic();
        hero.appearanceMovie = getAppearanceMovie();
        hero.powers = getPowers();
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

    public String getAppearanceComic() {
        return appearanceComic;
    }

    public void setAppearanceComic(String appearanceComic) {
        this.appearanceComic = appearanceComic;
    }

    public String getAppearanceMovie() {
        return appearanceMovie;
    }

    public void setAppearanceMovie(String appearanceMovie) {
        this.appearanceMovie = appearanceMovie;
    }

    public String getPowers() {
        return powers;
    }

    public void setPowers(String powers) {
        this.powers = powers;
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
}
