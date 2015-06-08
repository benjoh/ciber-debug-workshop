package no.ciber.tutorial.spring_hibernate.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MOVIE", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class MovieModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String title;
    @Column
    private String year;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<SuperheroModel> heroes;
    @Column
    private String posterUrl;

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

    public List<SuperheroModel> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<SuperheroModel> heroes) {
        this.heroes = heroes;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }
}
