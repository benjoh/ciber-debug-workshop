package no.ciber.tutorial.spring_hibernate.config;

import no.ciber.tutorial.spring_hibernate.domain.Movie;
import no.ciber.tutorial.spring_hibernate.domain.Superhero;
import no.ciber.tutorial.spring_hibernate.model.HeroGroup;
import no.ciber.tutorial.spring_hibernate.services.MovieService;
import no.ciber.tutorial.spring_hibernate.services.SuperheroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AppSetup {
    @Autowired
    MovieService movieService;

    @Autowired
    SuperheroService superheroService;

    public AppSetup(){

    }

    @PostConstruct
    private void setup(){
       /* try {*/
            Movie m;

            Superhero h = createSuperhero("Howard the Duck", "Howard", "http://static.comicvine.com/uploads/original/0/533/81455-159557-howard-the-duck.gif", HeroGroup.DEFENDERS);
            h.addMovie(createMovie("Howard The Duck", "1986"));
            superheroService.save(h);

            h = createSuperhero("Captain America", "Steve Rodgers", "http://img2.wikia.nocookie.net/__cb20100205184014/marveldatabase/images/f/f0/Steven_Rogers_(Earth-1610).png", HeroGroup.AVENGERS);
            h.addMovie(createMovie("Captain America", "1990"));

            h.addMovie(createMovie("Captain America: The First Avenger", "2011"));
            h.addMovie(createMovie("Captain America: The Winter Soldier", "2014"));
            superheroService.save(h);

            h = createSuperhero("Blade", "", "http://vignette1.wikia.nocookie.net/avengersalliance/images/6/6c/Blade-Modern.png/revision/latest?cb=20141029114925", HeroGroup.ANDRE);
            superheroService.save(h);

            h = createSuperhero("The Hulk", "Bruce Banner", "https://www.irononsticker.com/images/The%20Hulk%202.jpg", HeroGroup.AVENGERS);
            h.addMovie(createMovie("Hulk", "2003"));
            h.addMovie(createMovie("The Avengers", "2012"));
            superheroService.save(h);

            m = new Movie();
            m.setTitle("Blade");
            m.setYear("1998");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("X-men");
            m.setYear("2000");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Blade II");
            m.setYear("2002");
            m.setPosterUrl("");
            movieService.save(m);


            h = createSuperhero("Daredevil", "Matt Murdoc", "http://vignette3.wikia.nocookie.net/p__/images/8/8f/Daredevil.png/revision/latest?cb=20140715191442&path-prefix=protagonist", HeroGroup.ANDRE );
            h.addMovie(createMovie("Daredevil", "2003"));
            h.addMovie(createMovie("Daredevil (tv-series)", "2015"));
            superheroService.save(h);

            h = createSuperhero("Green Arrow", "Oliver Queen", "http://pre14.deviantart.net/396a/th/pre/i/2013/136/b/8/green_arrow_by_bobhertley-d65hewv.png", HeroGroup.ANDRE);
            h.addMovie(createMovie("Arrow", "2013"));
            superheroService.save(h);

            h = createSuperhero("Flash", "Barry Allen", "http://www.renders-graphics.com/image/upload/normal/Flash-1.png", HeroGroup.ANDRE);
            h.addMovie(createMovie("The Flash", "2014"));
            superheroService.save(h);

            h = createSuperhero("Wolverine", "James Howlett", "http://cliparts.co/cliparts/kTM/nbA/kTMnbAGpc.png", HeroGroup.X_MEN);
            superheroService.save(h);

            superheroService.save(createSuperhero("Groot", "", "http://img1.wikia.nocookie.net/__cb20140813000856/marveldatabase/images/0/09/Groot_(Earth-12131)_001.png", HeroGroup.GUARDIANS_OF_THE_GALAXY));
            superheroService.save(createSuperhero("Spider-Man", "Peter Parker", "http://www.pngimage.com/wp-content/uploads/2015/04/Spiderman_png_by_captainjackharkness-d5cbru1.png", HeroGroup.ANDRE));
            superheroService.save(createSuperhero("Batman", "", "http://40.media.tumblr.com/tumblr_me12jvfwSz1qczbido1_500.png", HeroGroup.ANDRE));
            superheroService.save(createSuperhero("Superman", "Klark Kent", "http://cdn6.triplepundit.com/wp-content/uploads/2010/10/superman-standing.gif", HeroGroup.ANDRE));
            superheroService.save(createSuperhero("Ultron", "", "http://static.comicvine.com/uploads/original/11119/111192788/4551282-0585895317-aveng.png", HeroGroup.EVIL_MUTANTS));
            superheroService.save(createSuperhero("Black Bolt", "Blackagar Boltagon", "http://fc06.deviantart.net/fs71/f/2015/053/9/3/black_bolt_by_arkhamnatic-d8j4vl9.png", HeroGroup.INHUMANS));
            superheroService.save(createSuperhero("Doctor Strange", "Stephen Strange","http://img1.wikia.nocookie.net/__cb20130515191659/marveldatabase/images/2/29/Stephen_Strange_(Earth-12131)_001.png", HeroGroup.ILLUMINATI ));
            superheroService.save(createSuperhero("Shadowcat", "Kitty Pryde", "http://static.giantbomb.com/uploads/square_small/1/15955/2503596-kitty_pryde_marvel_xp.png", HeroGroup.X_MEN));
            superheroService.save(createSuperhero("Atom", "Ray Palmer","https://pmcvariety.files.wordpress.com/2015/02/ar315c_atom_0001_w2-v.jpg?w=670", HeroGroup.ANDRE ));
            superheroService.save(createSuperhero("Mystique", "Raven Darkholme", "http://img2.wikia.nocookie.net/__cb20120316001448/avengersalliance/images/0/0a/Mystique_Marvel_XP.png", HeroGroup.EVIL_MUTANTS));

            m = new Movie();
            m.setTitle("X2");
            m.setYear("2003");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("The Punisher");
            m.setYear("2004");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Blade: Trinity");
            m.setYear("2004");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Elektra");
            m.setYear("2005");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Man-Thing");
            m.setYear("2005");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Fantastic Four");
            m.setYear("2005");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("X-Men: The Last Stand");
            m.setYear("2006");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Iron Man");
            m.setYear("2008");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("The Incredible Hulk");
            m.setYear("2008");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Punisher: War Zone");
            m.setYear("2008");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("X-Men Origins: Wolverine");
            m.setYear("2009");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Iron Man 2");
            m.setYear("2010");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Thor");
            m.setYear("2011");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("X-men: First Class");
            m.setYear("2011");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Ghost Rider: Spirit of Vengeance");
            m.setYear("2012");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("The Amazing Spider-Man");
            m.setYear("2012");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("The Wolverine");
            m.setYear("2013");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Iron Man 3");
            m.setYear("2013");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Thor: The Dark World");
            m.setYear("2013");
            m.setPosterUrl("");
            movieService.save(m);


            m = new Movie();
            m.setTitle("The Amazing Spider-Man 2");
            m.setYear("2014");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("X-Men: Days of Future Past");
            m.setYear("2014");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Guardians of the Galaxy");
            m.setYear("2014");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Avengers: Age of Ultron");
            m.setYear("2015");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Ant-Man");
            m.setYear("2015");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Catwoman");
            m.setYear("2004");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Batman Begins");
            m.setYear("2005");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Watchmen");
            m.setYear("2009");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Green Lantern");
            m.setYear("2011");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Man of Steel");
            m.setYear("2013");
            m.setPosterUrl("");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Spider-Man");
            m.setYear("2002");
            m.setPosterUrl("http://vignette1.wikia.nocookie.net/spiderman-films/images/a/a7/Spider-Man_Poster_2.jpg/revision/latest?cb=20130416061601");
            movieService.save(m);

            m = new Movie();
            m.setTitle("Spider-Man 2");
            m.setYear("2004");
            m.setPosterUrl("http://vignette3.wikia.nocookie.net/spiderman-films/images/0/02/Spider-Man_2_Poster.jpg/revision/latest?cb=20121105001752");
            movieService.save(m);
    }

    private Superhero createSuperhero(String heroName, String name, String imageUrl, HeroGroup herogroup) {
        Superhero h = new Superhero();
        h.setHeroName(heroName);
        h.setRealName(name);
        h.setImageUrl(imageUrl);
        h.setGroupAffiliation(herogroup);
        return h;
    }

    private Movie createMovie(String title, String year) {
        Movie m = new Movie();
        m.setTitle(title);
        m.setYear(year);
        m.setPosterUrl("");
        return m;
    }
}
