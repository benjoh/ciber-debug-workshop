package no.ciber.tutorial.spring_hibernate.domain;

public class Kjoretoy {
    private String understellsnummer;
    private String registreringsnummer;
    private String merke;
    private String modell;
    private String registreringsaar;
    private Person eier;

    public Kjoretoy(String understellsnummer) {
        this.understellsnummer = understellsnummer;
    }

    public String getUnderstellsnummer() { return understellsnummer; }

    public Kjoretoy understellsnummer(String understellsnummer) {
        Kjoretoy copy = copy();
        copy.understellsnummer = understellsnummer;
        return copy;
    }

    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public Kjoretoy registreringsnummer(String registreringsnummer) {
        Kjoretoy copy = copy();
        copy.registreringsnummer = registreringsnummer;
        return copy;
    }

    public String getMerke() {
        return merke;
    }

    public Kjoretoy merke(String merke) {
        Kjoretoy copy = copy();
        copy.merke = merke;
        return copy;
    }

    public String getModell() {
        return modell;
    }

    public Kjoretoy modell(String modell) {
        Kjoretoy copy = copy();
        copy.modell = modell;
        return copy;
    }

    public String getRegistreringsaar() {
        return registreringsaar;
    }

    public Kjoretoy registreringsaar(String registreringsaar) {
        Kjoretoy copy = copy();
        copy.registreringsaar = registreringsaar;
        return copy;
    }

    public Person getEier() {
        return eier;
    }

    public Kjoretoy eier(Person eier) {
        Kjoretoy copy = copy();
        copy.eier = eier;
        return copy;
    }

    private Kjoretoy copy(){
        Kjoretoy kjoretoy = new Kjoretoy(getUnderstellsnummer());
        kjoretoy.merke = getMerke();
        kjoretoy.modell = getModell();
        kjoretoy.eier = getEier();
        kjoretoy.registreringsaar = getRegistreringsaar();
        kjoretoy.registreringsnummer = getRegistreringsnummer();
        return kjoretoy;
    }
}
