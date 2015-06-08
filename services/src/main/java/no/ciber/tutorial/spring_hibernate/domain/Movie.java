package no.ciber.tutorial.spring_hibernate.domain;

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
import no.ciber.tutorial.spring_hibernate.model.SuperheroModel;

import java.util.List;

public class Movie {
    private Long id;
    private String title;
    private String year;
    private List<Superhero> heroes;
    private String posterUrl;

    public Movie(){}

    public Movie(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Superhero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Superhero> heroes) {
        this.heroes = heroes;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public Movie title(String title) {
        Movie movie = copy();
        movie.title = title;
        return movie;
    }

    public Movie year(String year) {
        Movie movie = copy();
        movie.year = year;
        return movie;
    }

    public Movie heroes(List<Superhero> heroes) {
        Movie movie = copy();
        movie.heroes = heroes;
        return movie;
    }

    public Movie posterUrl(String posterUrl) {
        Movie movie = copy();
        movie.posterUrl = posterUrl;
        return movie;
    }

    private Movie copy() {
        Movie movie = new Movie(getId());
        movie.title = getTitle();
        movie.posterUrl = getPosterUrl();
        movie.year = getYear();
        movie.heroes = getHeroes();
        return movie;
    }
}
