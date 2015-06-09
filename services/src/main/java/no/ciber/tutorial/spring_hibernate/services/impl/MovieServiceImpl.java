package no.ciber.tutorial.spring_hibernate.services.impl;

import no.ciber.tutorial.spring_hibernate.dao.MovieDAO;
import no.ciber.tutorial.spring_hibernate.domain.Movie;
import no.ciber.tutorial.spring_hibernate.mapping.MovieMapper;
import no.ciber.tutorial.spring_hibernate.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static no.ciber.tutorial.spring_hibernate.mapping.MovieMapper.fromMovieModel;
import static no.ciber.tutorial.spring_hibernate.mapping.MovieMapper.toMovieModel;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieDAO movieDao;

    @Override
    public Movie save(Movie movie) {
        return fromMovieModel(movieDao.save(toMovieModel(movie).get())).get();
    }

    @Override
    public Optional<Movie> findOne(Long id) {
        return fromMovieModel(movieDao.findOne(id));
    }

    @Override
    public List<Movie> findAll() {
        return MovieMapper.fromMovies(movieDao.findAll());
    }
}
