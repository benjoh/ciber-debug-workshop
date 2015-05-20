#Ciber Spring-Hibernate tutorial


##Krav
* [Java (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.x](http://maven.apache.org/)
* Nettleser med REST-verktøy innstallert. I Chrome benytt [Advanced Rest Client](https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo) 
eller [Postman](https://chrome.google.com/webstore/detail/postman-rest-client/fdmmgilgnpjigdojojpjoooidkmcomcm).

##Intro
Dette repositoriet inneholder en kode til en applikasjon som brukes i Cibers Spring-Hibernate tutorial.
Applikasjonen er skrevet i Java 8 og bygger vha. Maven. Det er en veldig enkelt 3-lags applikasjon 
som man gjennom tutorialen skal modifisere for å få en helt basic innføring i Spring og Hibernate.
Hvert lag i applikasjonen er representert som en egen modul (jar).  

Oppgave 1-5 er oppgaver knyttet til Springs IOC-kontainer og bruken av denne via SpringWebMVC.
Oppgave 6-8 er oppgaver knyttet til Hibernate.

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
Aktiver også komponent-skanning for pakken [no.ciber.tutorial.spring_hibernate.controllers](https://github.com/peteabre/spring-hibernate-tutorial/tree/master/web/src/main/java/no/ciber/tutorial/spring_hibernate/controllers).
Klasser som blir plukket opp av komponent-skanningen i denne pakken er markert med @Controller eller @RestController. 
De blir registrert i IOC-kontaineren og kan senere injiseres i andre klasser ved behov.

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
Registrer tjenestene som har navn som begynner med Simple (3 stk).

*hint:*
``` java
@Bean  
public Service method(){
    return new ServiceImpl()
}
```
Når klassene er registrert i IOC-kontaineren kan de injiseres i andre klasser ved behov.

###Oppgave 4 - Aktiver controller-klassene og endepunktene definert i klassene.
Modifiser kontroller-klassene i [no.ciber.tutorial.spring_hibernate.controllers](https://github.com/peteabre/spring-hibernate-tutorial/blob/master/web/src/main/java/no/ciber/tutorial/spring_hibernate/controllers/) 
(ikke [IndexController](https://github.com/peteabre/spring-hibernate-tutorial/blob/master/web/src/main/java/no/ciber/tutorial/spring_hibernate/controllers/IndexController.java)), 
slik at de blir plukket opp av komponent-skanningen som ble aktivert i oppgave 2.
Metodene i controller-klassene representerer "endepunkt" som skal kunne nås på ulike urler. 
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
Start applikasjonen på nytt og naviger til de ulike urlene for AdresseController på [http://localhost:8080/](http://localhost:8080/) for å verifisere at eksponeringen du har gjort funker.

###Oppgave 5 - Sett opp støtte for injisering av properties fra properties-fil.
Spring støtter injisering av verdier fra properties-filer. I konfigurasjonsfilen [PropertySourceConfig]() er laget et begynnende konfigurasjonselement for dette.
Legg inn lokasjonen til [config.properties](https://github.com/peteabre/spring-hibernate-tutorial/blob/master/web/src/main/resources/config.properties) 
i [PropertySourcesPlaceholderConfigurer]() som en [ClassPathResource](). Og aktiver konfigurasjonselementet vha. riktige annotasjoner.
Injiser så verdien av propertien som er definert i filen i [IndexController](https://github.com/peteabre/spring-hibernate-tutorial/blob/master/web/src/main/java/no/ciber/tutorial/spring_hibernate/controllers/IndexController.java) 
slik at verdien av propertien kommer opp når man går til [http://localhost:8080](http://localhost:8080)

*hint:*
``` java
@Value("${property.heroName}")
private String message;
```
###Oppgave 6 - Hibernate datasource
For å benytte JPA (Java Persistence API) og Hibernate må man sette opp en datasource. Datasourcen er oppkoblingen til databasen. 
I applikasjonen benyttes en enkel "in-memory" HSQLDB. Databasen blir opprettet når applikasjonen starter og slettes igjen når applikasjonen stopper.
For å aksessere databasen knytter man en EntityManager mot datasourcen. I vårt eksempel med *Spring* og *Hibernate 4* så benytter vi JPA.
For datasource bruker vi en [BasicDataSource]() og for EnitityManager [LocalContainerEntityManagerFactoryBean]().

Konfigurer opp en [BasisDataSource]() og [LocalContainerEntityManagerFactoryBean]() i [DatasourceConfig](https://github.com/peteabre/spring-hibernate-tutorial/blob/master/repository/src/main/java/no/ciber/tutorial/spring_hibernate/config/DatasourceConfig.java). Husk å aktiver Springs-transaksjonsstyring og JPA-scanning av DAO (repository) klasser.
Nedenfor er en liste med attributter som må settes på datasourcen. Under der igjen er Hibernate-properties som må settes på sessionfactory.
Aktiver også JPARepositoriene til Spring-data. Dette gjøres ved å benytte annotasjonen @EnableJpaRepositories(basePackages="no.ciber.tutorial.spring_hibernate.dao"). 

#####Datasource attributter
| Attributt        | Verdi                |
| ---------------- |:--------------------:|
|DriverClassName   |org.hsqldb.jdbcDriver |
|Url               |jdbc:hsqldb:mem:testdb|
|Username          |sa                    |
|Password          |                      |

#####Hibernate-properties
| Key                  | Value                           |
| -------------------- |:-------------------------------:|
|hibernate.dialect     |org.hibernate.dialect.HSQLDialect|
|hibernate.hbm2ddl.auto|update                           |

Man kan benytte xml-konfigurering av Hibernate (Definere alle modell-klassene som hibernate skal benytte).
I denne omgangen så lar vi Hibernate scanne etter klassene som skal benyttes. Dette gjøres ved å sette annotatedPackages
til pakkene man ønsker skal scannes. For denne applikasjonen er det [no.ciber.tutorial.spring_hibernate.model](https://github.com/peteabre/spring-hibernate-tutorial/tree/master/repository/src/main/java/no/ciber/tutorial/spring_hibernate/model).

Start applikasjonen og verifiser i loggen at Hibernate kjører. 

*hint datasource oppsett:*
``` java
@Bean
public DataSource datasource(){
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName(DB_DRIVER_CLASS);
    ds.setUrl(DB_CONNECTION_URL);
    ds.setUsername(DB_USERNAME);
    ds.setPassword(DB_PASSWORD);
}
```

*hint sessionfactory oppsett:*
``` java
@Bean
@Autowired
public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    em.setPackagesToScan(MODEL_PACKAGE);
    em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    em.setJpaProperties(jpaProperties());
}

private Properties jpaProperties(){
    Properties hp = new Properties();
    hp.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
    hp.setProperty("hibernate.hbm2ddl.auto", "update");
    return hp;
}
```

###Oppgave 7 - Mapping av modell klasse
Hibernate er en JPA (Java Persistence API) provider, og støtter JPA-annotations for mapping. 
Benytt annotasjonene i tabellen under til å mappe opp klassen [AdresseModel](https://github.com/peteabre/spring-hibernate-tutorial/blob/master/repository/src/main/java/no/ciber/tutorial/spring_hibernate/model/AdresseModel.java). Sett eget navn på tabellen 
og kolonnene i databasen (De kan være det samme som attributtnavnet, men man bør eksplisitt angi kolonnenavn). 
Kolonne mappingene kan angis på feltene eller på get/set-metodene til feltet. Du velger selv hva du ønsker å benytte.


| Annotasjon       | Nivå            |
| ---------------- |:---------------:|
|@Entity           |Klasse           |
|@Table            |Klasse           |
|@Id               |Felt, Metode     |
|@GeneratedValue   |Felt, Metode     |
|@Column           |Felt, Metode     |

*hint:*
``` java
@Entity
@Table(heroName="tabell"
public class Tabell{
    @Id
    @GeneratedValue
    @Column(heroName="id")
    private Integer id;
    
    @Column(heroName="kolonne1")
    private String kolonne1
}
```
Fjern @Configuration annotasjonen fra [SimpleServiceConfig]() og legg den til i klassen [ServiceConfig](). 
Start deretter applikasjonen på nytt. Prøv og legge til Adresser og hente ut adresser ved hjelp av kall til REST-tjenestene.

###Oppgave 8 - Mapping av modellklasser med avhengigheter seg i mellom.
Utover annotasjonene som ble brukt i forrige oppgave. Ta i bruk en eller flere av annotasjonene under for å mappe opp 
[PersonModel](https://github.com/peteabre/spring-hibernate-tutorial/blob/master/repository/src/main/java/no/ciber/tutorial/spring_hibernate/model/PersonModel.java) 
og [KjoretoyModel](https://github.com/peteabre/spring-hibernate-tutorial/blob/master/repository/src/main/java/no/ciber/tutorial/spring_hibernate/model/KjoretoyModel.java).
Aktiver også Repositoriene for entitetene på samme måte som i forrige oppgave.

| Annotasjon       | Nivå            |
| ---------------- |:---------------:|
|@ManyToOne        |Felt, Metode     |
|@OneToMany        |Felt, Metode     |
|@JoinColumn       |Felt, Metode     |

*hint for person:*
``` java
@ManyToOne(fetch = EAGER)
@JoinColumn(heroName = "adresse", nullable = false)
private AdresseModel adresse;

@OneToMany(mappedBy = "eier", fetch = EAGER)
private List<KjoretoyModel> kjoretoy;
```
Start applikasjonen på nytt. Legg til Personer og Kjoretoy og hente dem ut igjen ved hjelp av kall til REST-tjenestene. 
