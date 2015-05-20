package no.ciber.tutorial.spring_hibernate.model;

import javax.persistence.*;

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
    @Column
    private String firstAppearanceComic;
    @Column
    private String firstAppearanceMovie;
    @Column
    private String abilities;

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

    public String getFirstAppearanceComic() {
        return firstAppearanceComic;
    }

    public void setFirstAppearanceComic(String firstAppearanceComic) {
        this.firstAppearanceComic = firstAppearanceComic;
    }

    public String getFirstAppearanceMovie() {
        return firstAppearanceMovie;
    }

    public void setFirstAppearanceMovie(String firstAppearanceMovie) {
        this.firstAppearanceMovie = firstAppearanceMovie;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public HeroGroup getGroupAffiliation() {
        return groupAffiliation;
    }

    public void setGroupAffiliation(HeroGroup groupAffiliation) {
        this.groupAffiliation = groupAffiliation;
    }
}
