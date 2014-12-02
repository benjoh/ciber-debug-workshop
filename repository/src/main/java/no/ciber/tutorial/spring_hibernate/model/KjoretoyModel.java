package no.ciber.tutorial.spring_hibernate.model;

public class KjoretoyModel {
    public String understellsnummer;
    public String registreringsnummer;
    public String merke;
    public String modell;
    public Integer registreringsaar;
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
