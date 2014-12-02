package no.ciber.tutorial.spring_hibernate.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name="PERSON")
public class PersonModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String fornavn;
    @Column
    private String mellomnavn;
    @Column
    private String etternavn;
    @Column
    private LocalDate fodelsdag;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "adresse", nullable = false)
    private AdresseModel adresse;

    @OneToMany(mappedBy = "eier", fetch = EAGER)
    private List<KjoretoyModel> kjoretoy;

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getMellomnavn() {
        return mellomnavn;
    }

    public void setMellomnavn(String mellomnavn) {
        this.mellomnavn = mellomnavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public LocalDate getFodelsdag() {
        return fodelsdag;
    }

    public void setFodelsdag(LocalDate fodelsdag) {
        this.fodelsdag = fodelsdag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AdresseModel getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseModel adresse) {
        this.adresse = adresse;
    }

    public List<KjoretoyModel> getKjoretoy() {
        return kjoretoy;
    }

    public void setKjoretoy(List<KjoretoyModel> kjoretoy) {
        this.kjoretoy = kjoretoy;
    }
}
