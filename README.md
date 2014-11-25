Ciber Spring-Hibernate tutorial
===============================

Dette repositoriet inneholder en kode til en applikasjon som brukes i Cibers Spring-Hibernate tutorial.
Applikasjonen er skrevet i Java 8 og bygger vha. Maven. Det er en veldig enkelt 3-lags applikasjon 
som man gjennom tutorialen skal modifisere for å få en helt basic innføring i Spring og Hibernate.
Hvert lag i applikasjonen er representert som en egen modul (jar).

Oppgave 1 - Sett opp enkel spring-context for web-modulen.
----------------------------------------------------------
Prosjektene legger opp til å benytte java-basert konfigurasjon.  
Modifiser WebConfig.java i web-modulen slik at de plukkes opp av Spring og aktiver SpringWebMVC.

*hint:*
``` java
@Configuration  
@EnableWebMvc  
```

Oppgave 2 - Benytt komponent-skanning for å finne controllere.
--------------------------------------------------------------
Modifiser AppConfig.java i web-modulen slik at den blir aktivert som en konfigurasjonsfil. 
Aktiver også komponent-skanning for pakken [no.ciber.tutorial.spring_hibernate.config](https://github.com/peteabre/spring-hibernate-tutorial/tree/master/web/src/main/java/no/ciber/tutorial/spring_hibernate/config)

*hint:*
``` java
@Configuration  
@ComponentScan  
```
Start applikasjonen ved å kjøre EmbeddedJetty klassen
Gå til [http://localhost:8080/](http://localhost:8080/) for å verifisere at applikasjonen kjører. (Skal vise Hello World)

Oppgave 3 - Aktiver controller-klassene og endepunktene definert i klassene.
----------------------------------------------------------------------------
Modifiser kontroller-klassene i [no.ciber.tutorial.spring_hibernate.controllers](), 
slik at de blir plukket opp av komponent-skanningen som ble aktivert i oppgave 2.
Metodene i controller-klassene representerer "endepunkt" som skal kunne nås på ulike urler. 
Urlene er beskrevet i kommentarer over hver metode. Aktiver endepunktene slik at de kan nås på riktig url.

*hint:*
``` java
@Controller
public class Controller{
    @RequestMapping(value="url", method = GET)
    public String endpoint(){
        return "view";
    }
}  
```
Naviger til ulike urler på [http://localhost:8080/](http://localhost:8080/) for å verifisere at det du har gjort funker.

