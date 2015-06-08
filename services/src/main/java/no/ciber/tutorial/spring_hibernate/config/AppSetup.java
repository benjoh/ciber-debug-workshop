package no.ciber.tutorial.spring_hibernate.config;

import no.ciber.tutorial.spring_hibernate.domain.Movie;
import no.ciber.tutorial.spring_hibernate.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AppSetup {
    @Autowired
    MovieService movieService;

    public AppSetup(){

    }

    @PostConstruct
    private void setup(){
        Movie m = new Movie();
        m.setTitle("Spider-Man");
        m.setYear("2002");
        m.setPosterUrl("http://vignette1.wikia.nocookie.net/spiderman-films/images/a/a7/Spider-Man_Poster_2.jpg/revision/latest?cb=20130416061601");
        movieService.save(m);

        m = new Movie();
        m.setTitle("Spider-Man 2");
        m.setYear("2004");
        m.setPosterUrl("http://vignette3.wikia.nocookie.net/spiderman-films/images/0/02/Spider-Man_2_Poster.jpg/revision/latest?cb=20121105001752");
        movieService.save(m);

        List<Movie> all = movieService.findAll();
        System.out.println(all.size());
    }
}
