package no.ciber.tutorial.spring_hibernate.domain;


public class Adresse {
    private Long id;
    private String linje1;
    private String linje2;
    private String linje3;
    private Integer postnummer;
    private String poststed;
    private String land;

    public Adresse(Long id) {
        this.id = id;
    }

    public String getLand() {
        return land;
    }

    public Adresse land(String land) {
        Adresse adresse = copy();
        adresse.land = land;
        return adresse;
    }

    public String getLinje1() {
        return linje1;
    }

    public Adresse linje1(String linje1) {
        Adresse adresse = copy();
        adresse.linje1 = linje1;
        return adresse;
    }

    public String getLinje2() {
        return linje2;
    }

    public Adresse linje2(String linje2) {
        Adresse adresse = copy();
        adresse.linje2 = linje2;
        return adresse;
    }

    public String getLinje3() {
        return linje3;
    }

    public Adresse linje3(String linje3) {
        Adresse adresse = copy();
        adresse.linje3 = linje3;
        return adresse;
    }

    public Integer getPostnummer() {
        return postnummer;
    }

    public Adresse postnummer(Integer postnummer){
        Adresse adresse = copy();
        adresse.postnummer = postnummer;
        return adresse;
    }

    public String getPoststed() {
        return poststed;
    }

    public Adresse poststed(String poststed) {
        Adresse adresse = copy();
        adresse.poststed = poststed;
        return adresse;
    }

    public Long getId() {
        return id;
    }

    private final Adresse copy() {
        Adresse adresse = new Adresse(getId());
        adresse.linje1 = getLinje1();
        adresse.linje2 = getLinje2();
        adresse.linje3 = getLinje3();
        adresse.postnummer = getPostnummer();
        adresse.poststed = getPoststed();
        adresse.land = getLand();
        return adresse;
    }

}
