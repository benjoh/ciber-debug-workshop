package no.ciber.tutorial.spring_hibernate.domain;

import no.ciber.tutorial.spring_hibernate.model.AdresseModel;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by petbre on 23.11.14.
 */
public class Person {
    private Long id;
    private String fornavn;
    private String mellomnavn;
    private String etternavn;
    private LocalDate fodelsdag;
    private Adresse adresse;
    private List<Kjoretoy> kjoretoy;

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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Kjoretoy> getKjoretoy() {
        return kjoretoy;
    }

    public void setKjoretoy(List<Kjoretoy> kjoretoy) {
        this.kjoretoy = kjoretoy;
    }
}
