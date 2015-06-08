package no.ciber.tutorial.spring_hibernate.model;

import javax.persistence.*;

@Entity
@Table(name="POWER")
public class PowerModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String shortName;
    @Column
    private String description;

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
}
