package hu.nye.progKor.movieCatalog.service;

import hu.nye.progKor.movieCatalog.entity.MovieEntity;
import hu.nye.progKor.movieCatalog.request.MovieRequest;

import java.util.List;

public interface MovieServiceInterface {

    MovieEntity saveMovie(MovieRequest movieRequest);

    MovieEntity getMovieById(Long id);

    MovieEntity updateMovie(Long id, MovieRequest movieRequest);

    void deleteMovieById(Long id);

    List<MovieEntity> findAllMoviesByMovieRate(int movieRate);

}
