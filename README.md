#Ciber Spring-Hibernate tutorial


##Krav
* [Java (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)

##Intro
Dette repositoriet inneholder en kode til en applikasjon som brukes i Cibers Spring-Hibernate tutorial.
Applikasjonen er skrevet i Java 8 og bygger vha. Maven. Det er en veldig enkelt 3-lags applikasjon 
som man gjennom tutorialen skal modifisere for å få en helt basic innføring i Spring og Hibernate.
Hvert lag i applikasjonen er representert som en egen modul (jar).  

Oppgave 1-5 er enkle oppgaver knyttet til Springs IOC-kontainer og bruken av denne via SpringWebMVC.
Oppgave 6-10 er oppgaver knyttet til Hibernate.
Oppgave 11-15 er oppgaver knyttet til mer avansert bruk av SpringWebMVC

Applikasjonen kan startes ved og kjøre [EmbeddedJetty](https://github.com/peteabre/spring-hibernate-tutorial/blob/master/web/src/main/java/no/ciber/tutorial/spring_hibernate/EmbeddedJetty.java) 
-klassen fra en ide. Eventuelt så kan man bygge og starte applikasjonen med kommandoene:
```sh
mvn clean package
java -jar web/target/web-1.0-SNAPSHOT.jar
```

###Oppgave 1 - Sett opp enkel spring-context for web-modulen.
Spring kan benytte xml-basert eller java-basert konfigurasjon. Prosjektene i denne tutorialen legger opp til å benytte java-basert konfigurasjon.  
Modifiser WebConfig.java i web-modulen slik at de plukkes opp av Spring og aktiver SpringWebMVC.

*hint:*
``` java
@Configuration  
@EnableWebMvc  
```

###Oppgave 2 - Benytt komponent-skanning for å finne controllere.
Modifiser AppConfig.java i web-modulen slik at den blir aktivert som en konfigurasjonsfil. 
Aktiver også komponent-skanning for pakken [no.ciber.tutorial.spring_hibernate.config](https://github.com/peteabre/spring-hibernate-tutorial/tree/master/web/src/main/java/no/ciber/tutorial/spring_hibernate/config)
Klasser som blir plukket opp av komponent-skanningen blir registrert i IOC-kontaineren og kan senere injiseres i andre klasser ved behov.

*hint:*
``` java
@Configuration  
@ComponentScan  
```
Start applikasjonen ved å kjøre EmbeddedJetty klassen. 
Gå til [http://localhost:8080/](http://localhost:8080/) for å verifisere at applikasjonen kjører. (Skal vise Hello World)

###Oppgave 3 - Konfigurer opp service-laget i applikasjonen
Man kan også benytte komponentscanning for å finne tjenester. Denne oppgaven skal derimot løses ved at man manuelt konfigurere opp et par av tjenestene.
Aktiver SimpleServiceConfig som en konfigurasjonsfil. Deretter så må man tilgjengeligjøre/registrere hver tjeneste som spring-beans i IOC-kontaineren.

*hint:*
``` java
@Bean  
public Service method(){
    return new ServiceImpl()
}
```
Når klassene er registrert i IOC-kontaineren kan de injiseres i andre klasser ved behov.

###Oppgave 4 - Aktiver controller-klassene og endepunktene definert i klassene.
Modifiser kontroller-klassen [no.ciber.tutorial.spring_hibernate.controllers.AdresseController](https://github.com/peteabre/spring-hibernate-tutorial/blob/master/web/src/main/java/no/ciber/tutorial/spring_hibernate/controllers/AdresseController.java), 
slik at den blir plukket opp av komponent-skanningen som ble aktivert i oppgave 2.
Metodene i controller-klassen representerer "endepunkt" som skal kunne nås på ulike urler. 
Urlene er beskrevet i kommentarer over hver metode. Aktiver endepunktene slik at de kan nås på riktig url.
Kontrolleren benytter også en tjeneste for å hente ut data. Denne tjenesten må injiseres i kontrolleren. 
Man kan da benytte setter-injisering eller konstruktør-injisering. Gjerne prøv begge deler (ikke samtidig). 

*hint for konstruktør-injisering*
``` java
public class Controller{
    private Service service
    @Autowired
    public Controller(Service service){
        this.service = service;
    }
}  
```

*hint for setter-injisering*
``` java
public class Controller{
    private Service service
    @Autowired
    public void setService(Service service){
        this.service = service;
    }
}  
```

*hint for endepunkt-eksponering:*
``` java
@RestController
public class Controller{
    @RequestMapping(value="url", method = GET)
    public String endpoint(){
        return "view";
    }
}  
```
Start applikasjonen på nytt og naviger til de ulike urlene på [http://localhost:8080/](http://localhost:8080/) for å verifisere at eksponeringen du har gjort funker.

###Oppgave 5 - Sett opp støtte for injisering av properties fra properties-fil.
Spring støtter injisering av verdier fra properties-filer. I konfigurasjonsfilen [PropertySourceConfig]() er laget et begynnende konfigurasjonselement for dette.
Legg inn lokasjonen til [config.properties]() i [PropertySourcesPlaceholderConfigurer]() som en [ClassPathResource](). Og aktiver konfigurasjonselementet vha. riktige annotasjoner.
Injiser så verdien av propertien som er definert i filen i [IndexController]() slik at verdien av propertien kommer opp når man går til [http://localhost:8080](http://localhost:8080)

*hint:*
``` java
@Value("${property.name}")
private String message;
```
###Oppgave 6 - Hibernate datasource
For å benytte Hibernate må man sette opp en datasource. Datasourcen er oppkoblingen til databasen. 
I applikasjonen benyttes en enkel "in-memory" HSQLDB. Databasen blir opprettet når applikasjonen starter og slettes igjen når applikasjonen stopper.
For å aksessere databasen knytter man et SessionFactory mot datasourcen. I vårt eksempel med *Spring* og *Hibernate 4* så benytter vi
[BasicDataSource]() og [LocalSessionFactoryBean]().

Konfigurer opp en [BasisDataSource]() og [LocalSessionFactoryBean]() i [DatasourceConfig](). Husk å aktiver Springs transaksjonsstyring.
Nedenfor er en liste med attributter som må settes på datasourcen. Under der igjen er Hibernate-properties som må settes på sessionfactory.

#####Datasource attributter
| Attributt        | Verdi                |
| ---------------- |:--------------------:|
|DriverClassName   |org.hsqldb.jdbcDriver |
|Url               |jdbc:hsqldb:mem:testdb|
|Username          |sa                    |
|Password          |                      |

######Hibernate-properties
| Key                  | Value                           |
| -------------------- |:-------------------------------:|
|hibernate.dialect     |org.hibernate.dialect.HSQLDialect|
|hibernate.hbm2ddl.auto|update                           |

Man kan benytte xml-konfigurering av Hibernate (Definere alle modell-klassene som hibernate skal benytte).
I denne omgangen så lar vi Hibernate scanne etter klassene som skal benyttes. Dette gjøres ved å sette annotatedPackages
til packene man ønsker skal scannes. For denne applikasjonen er det [no.ciber.tutorial.spring_hibernate.model]().

*hint datasource oppsett:*
``` java
BasicDataSource ds = new BasicDataSource();
ds.setDriverClassName(DB_DRIVER_CLASS);
ds.setUrl(DB_CONNECTION_URL);
ds.setUsername(DB_USERNAME);
ds.setPassword(DB_PASSWORD);
```

*hint sessionfactory oppsett:*
``` java
public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource){
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setAnnotatedPackages(MODEL_PACKAGE);
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
}
private Properties hibernateProperties(){
    Properties hp = new Properties();
    hp.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
    hp.setProperty("hibernate.hbm2ddl.auto", "update");
    return hp;
}
```

