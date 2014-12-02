package no.ciber.tutorial.spring_hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "KJORETOY")
public class KjoretoyModel {
    @Id
    @Column
    public String understellsnummer;

    @Column
    public String registreringsnummer;

    @Column
    public String merke;

    @Column
    public String modell;

    @Column
    public Integer registreringsaar;

    @Column
    public Long eier;

    public String getUnderstellsnummer() {
        return understellsnummer;
    }

    public void setUnderstellsnummer(String understellsnummer) {
        this.understellsnummer = understellsnummer;
    }

    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public void setRegistreringsnummer(String registreringsnummer) {
        this.registreringsnummer = registreringsnummer;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public Integer getRegistreringsaar() {
        return registreringsaar;
    }

    public void setRegistreringsaar(Integer registreringsaar) {
        this.registreringsaar = registreringsaar;
    }

    public Long getEier() {
        return eier;
    }

    public void setEier(Long eier) {
        this.eier = eier;
    }
}
