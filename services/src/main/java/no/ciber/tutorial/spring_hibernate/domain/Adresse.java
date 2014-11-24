package no.ciber.tutorial.spring_hibernate.domain;

public class Adresse {
    private Long id;
    private String linje1;
    private String linje2;
    private String linje3;
    private Integer postnummer;
    private String poststed;
    private String land;

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getLinje1() {
        return linje1;
    }

    public void setLinje1(String linje1) {
        this.linje1 = linje1;
    }

    public String getLinje2() {
        return linje2;
    }

    public void setLinje2(String linje2) {
        this.linje2 = linje2;
    }

    public String getLinje3() {
        return linje3;
    }

    public void setLinje3(String linje3) {
        this.linje3 = linje3;
    }

    public Integer getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(Integer postnummer) {
        this.postnummer = postnummer;
    }

    public String getPoststed() {
        return poststed;
    }

    public void setPoststed(String poststed) {
        this.poststed = poststed;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
