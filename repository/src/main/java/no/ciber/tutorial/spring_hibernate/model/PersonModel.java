package no.ciber.tutorial.spring_hibernate.model;

import java.time.LocalDate;
import java.util.List;

public class PersonModel {

    private Long id;
    private String fornavn;
    private String mellomnavn;
    private String etternavn;
    private LocalDate fodelsdag;
    private AdresseModel adresse;
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
