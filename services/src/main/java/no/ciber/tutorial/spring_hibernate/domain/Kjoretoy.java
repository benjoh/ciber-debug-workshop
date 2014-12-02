package no.ciber.tutorial.spring_hibernate.domain;

public class Kjoretoy {
    private String understellsnummer;
    private String registreringsnummer;
    private String merke;
    private String modell;
    private Integer registreringsaar;
    private Long eier;

    public Kjoretoy() {
    }

    public Kjoretoy(String understellsnummer) {
        this.understellsnummer = understellsnummer;
    }

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

    public Kjoretoy registreringsnummer(String registreringsnummer) {
        Kjoretoy copy = copy();
        copy.registreringsnummer = registreringsnummer;
        return copy;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public Kjoretoy merke(String merke) {
        Kjoretoy copy = copy();
        copy.merke = merke;
        return copy;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public Kjoretoy modell(String modell) {
        Kjoretoy copy = copy();
        copy.modell = modell;
        return copy;
    }

    public Integer getRegistreringsaar() {
        return registreringsaar;
    }

    public void setRegistreringsaar(Integer registreringsaar) {
        this.registreringsaar = registreringsaar;
    }

    public Kjoretoy registreringsaar(Integer registreringsaar) {
        Kjoretoy copy = copy();
        copy.registreringsaar = registreringsaar;
        return copy;
    }

    public Long getEier() {
        return eier;
    }

    public void setEier(Long eier) {
        this.eier = eier;
    }

    public Kjoretoy eier(Long eier) {
        Kjoretoy copy = copy();
        copy.eier = eier;
        return copy;
    }

    private Kjoretoy copy() {
        Kjoretoy kjoretoy = new Kjoretoy(getUnderstellsnummer());
        kjoretoy.merke = getMerke();
        kjoretoy.modell = getModell();
        kjoretoy.eier = getEier();
        kjoretoy.registreringsaar = getRegistreringsaar();
        kjoretoy.registreringsnummer = getRegistreringsnummer();
        return kjoretoy;
    }
}
