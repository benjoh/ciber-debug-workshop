package no.ciber.tutorial.spring_hibernate.mapping;

import no.ciber.tutorial.spring_hibernate.domain.Movie;
import no.ciber.tutorial.spring_hibernate.model.MovieModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class MovieMapper {

    public static List<Movie> fromMovies(Iterable<MovieModel> movieAppearances) {
        List<Movie> movies = new ArrayList<>();
        movieAppearances.forEach(movieModel -> movies.add(fromMovieModel(movieModel).get()));
        return movies;
    }

    public static Optional<Movie> fromMovieModel(MovieModel model) {
        if (model == null) {
            return Optional.empty();
        }
        return Optional.of(new Movie(model.getId())
                .title(model.getTitle())
                .year(model.getYear())
                .heroes(SuperheroMapper.fromSuperheroModelList(model.getHeroes()))
                .posterUrl(model.getPosterUrl()));
    }

    public static List<MovieModel> toMovieModels(List<Movie> movies) {
        List<MovieModel> modelList = new ArrayList<>();
        movies.forEach(movie -> modelList.add(toMovieModel(movie).get()));
        return modelList;
    }

    public static Optional<MovieModel> toMovieModel(Movie movie) {
        if(movie == null){
            return Optional.empty();
        }
        MovieModel model = new MovieModel();
        model.setId(movie.getId());
        model.setTitle(movie.getTitle());
        model.setYear(movie.getYear());
        model.setPosterUrl(movie.getPosterUrl());
        if(movie.getHeroes() != null) model.setHeroes(SuperheroMapper.toSuperheroModelList(movie.getHeroes()));
        return Optional.of(model);
    }
}
