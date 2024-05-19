package hu.nye.progKor.movieCatalog.service;

import java.util.List;

import hu.nye.progKor.movieCatalog.entity.MovieEntity;
import hu.nye.progKor.movieCatalog.request.MovieRequest;

public interface MovieServiceInterface {

    MovieEntity saveMovie(MovieRequest movieRequest);

    MovieEntity getMovieById(Long id);

    MovieEntity updateMovie(Long id, MovieRequest movieRequest);

    void deleteMovieById(Long id);

    List<MovieEntity> findAllMoviesByMovieRate(int movieRate);

    List<MovieEntity> findAllMoviesByReleasedYear(int releasedYear);

    List<MovieEntity> findAllMoviesByMovieType(String movieType);

    List<MovieEntity> findAllMoviesByLengthInSeconds(int lengthInSeconds);

}
