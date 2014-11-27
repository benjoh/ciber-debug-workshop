package no.ciber.tutorial.spring_hibernate.domain;

import java.time.LocalDate;
import java.util.List;

public class Person {
    private Long id;
    private String fornavn;
    private String mellomnavn;
    private String etternavn;
    private LocalDate fodelsdag;
    private Adresse adresse;
    private List<Kjoretoy> kjoretoy;

    public Person(Long id) {
        this.id = id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public Person fornavn(String fornavn) {
        Person copy = copy();
        copy.fornavn = fornavn;
        return copy;
    }

    public String getMellomnavn() {
        return mellomnavn;
    }

    public Person mellomnavn(String mellomnavn) {
        Person copy = copy();
        copy.mellomnavn = mellomnavn;
        return copy;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public Person etternavn(String etternavn) {
        Person copy = copy();
        copy.etternavn = etternavn;
        return copy;
    }

    public LocalDate getFodelsdag() {
        return fodelsdag;
    }

    public Person fodelsdag(LocalDate fodelsdag) {
        Person copy = copy();
        copy.fodelsdag = fodelsdag;
        return copy;
    }

    public Long getId() {
        return id;
    }

    public Person id(Long id) {
        Person copy = copy();
        copy.id = id;
        return copy;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public Person adresse(Adresse adresse) {
        Person copy = copy();
        copy.adresse = adresse;
        return copy;
    }

    public List<Kjoretoy> getKjoretoy() {
        return kjoretoy;
    }

    public Person kjoretoy(List<Kjoretoy> kjoretoy) {
        Person copy = copy();
        copy.kjoretoy = kjoretoy;
        return copy;
    }

    private Person copy(){
        Person copy = new Person(getId());
        return copy;
    }
}
