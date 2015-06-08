package no.ciber.tutorial.spring_hibernate.mapping;

import no.ciber.tutorial.spring_hibernate.domain.Superhero;
import no.ciber.tutorial.spring_hibernate.model.SuperheroModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static no.ciber.tutorial.spring_hibernate.mapping.MovieMapper.fromMovies;
import static no.ciber.tutorial.spring_hibernate.mapping.MovieMapper.toMovieModels;

public final class SuperheroMapper {
    private SuperheroMapper() {
    }

    public static Optional<Superhero> fromSuperheroModel(SuperheroModel model) {
        if (model == null) {
            return Optional.empty();
        }
        return Optional.of(new Superhero(model.getId())
                .name(model.getName())
                .realName(model.getRealName())
                .height(model.getHeight())
                .movieAppearances(fromMovies(model.getMovieAppearances()))
                .powers(model.getPowers())
                .group(model.getGroupAffiliation())
                .imageUrl(model.getImageUrl()));
    }

    public static List<Superhero> fromSuperheroModelList(Iterable<SuperheroModel> modelList) {
        List<Superhero> heroes = new ArrayList<>();
        if(modelList != null) modelList.forEach(superheroModel -> heroes.add(fromSuperheroModel(superheroModel).get()));
        return heroes;
    }

    public static Optional<SuperheroModel> toSuperheroModel(Superhero superhero) {
        if(superhero == null){
            return Optional.empty();
        }
        SuperheroModel model = new SuperheroModel();
        model.setId(superhero.getId());
        model.setName(superhero.getHeroName());
        model.setImageUrl(superhero.getImageUrl());
        model.setRealName(superhero.getRealName());
        model.setHeight(superhero.getHeight());
        model.setMovieAppearances(toMovieModels(superhero.getMovieAppearances()));
        model.setPowers(superhero.getSuperpowers());
        model.setGroupAffiliation(superhero.getGroupAffiliation());
        return Optional.of(model);
    }

    public static List<SuperheroModel> toSuperheroModelList(List<Superhero> superheroes) {
        List<SuperheroModel> modelList = new ArrayList<>();
        superheroes.forEach(hero -> modelList.add(toSuperheroModel(hero).get()));
        return modelList;
    }
}
