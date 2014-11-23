package no.ciber.tutorial.spring_hibernate.model;

public class Adresse {

    public Long id;
    public String linje1;
    public String linje2;
    public String lunje3;
    public Integer postnummer;
    public String poststed;
    public String land;

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

    public String getLunje3() {
        return lunje3;
    }

    public void setLunje3(String lunje3) {
        this.lunje3 = lunje3;
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
}
