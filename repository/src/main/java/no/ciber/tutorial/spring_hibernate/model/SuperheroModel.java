package no.ciber.tutorial.spring_hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="SUPERHERO")
public class SuperheroModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String imageUrl;
    @Column
    private String realName;
    @Column
    private int height;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MovieModel> movieAppearances;
    @Column
    private String powers;

    @Enumerated(EnumType.STRING)
    private HeroGroup groupAffiliation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public List<MovieModel> getMovieAppearances() {
        return movieAppearances;
    }

    public void setMovieAppearances(List<MovieModel> movieAppearances) {
        this.movieAppearances = movieAppearances;
    }

    public String getPowers() {
        return powers;
    }

    public void setPowers(String powers) {
        this.powers = powers;
    }
}
