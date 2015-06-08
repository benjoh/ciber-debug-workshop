package no.ciber.tutorial.spring_hibernate.model;

public enum HeroGroup {
    X_MEN("X-men"),
    FANTASTIC_4("Fantastic 4"),
    AVENGERS("The Avengers"),
    GUARDIANS_OF_THE_GALAXY("Guardians of the Galaxy"),
    DEFENDERS("Defenders"),
    ILLUMINATI("Illuminati"),
    INHUMANS("Inhumans"),
    EVIL_MUTANTS("Brotherhood of Evil Mutants"),
    OTHER("Annnen gruppering");

    private String groupName;
    HeroGroup(String group) {
        groupName = group;
    }

    public String getGroupName() {
        return groupName;
    }
}
