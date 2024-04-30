package hu.nye.progKor.movieCatalog.service;

import hu.nye.progKor.movieCatalog.entity.MovieEntity;
import hu.nye.progKor.movieCatalog.exception.MovieNotFoundException;
import hu.nye.progKor.movieCatalog.repository.MovieRepositoryInterface;
import hu.nye.progKor.movieCatalog.request.MovieRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService implements MovieServiceInterface {

    @Autowired
    private MovieRepositoryInterface movieRepository;

    @Override
    public MovieEntity saveMovie(MovieRequest movieRequest) {
        MovieEntity movieEntity = MovieEntity.builder()
                .directorName(movieRequest.getDirectorName())
                .movieRate(movieRequest.getMovieRate())
                .releasedYear(movieRequest.getReleasedYear())
                .movieType(movieRequest.getMovieType())
                .description(movieRequest.getDescription())
                .lengthInSeconds(movieRequest.getLengthInSeconds())
                .build();
        return movieRepository.save(movieEntity);
    }

    @Override
    @SneakyThrows
    public MovieEntity getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }


    @Override
    @SneakyThrows
    public MovieEntity updateMovie(Long id, MovieRequest movieRequest) {
        MovieEntity movieEntity = movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
            movieEntity.setDirectorName(movieRequest.getDirectorName());
            movieEntity.setMovieRate(movieRequest.getMovieRate());
            movieEntity.setReleasedYear(movieRequest.getReleasedYear());
            movieEntity.setMovieType(movieRequest.getMovieType());
            movieEntity.setDescription(movieRequest.getDescription());
            movieEntity.setLengthInSeconds(movieRequest.getLengthInSeconds());
        return movieRepository.save(movieEntity);
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<MovieEntity> findAllMoviesByMovieRate(int movieRate) {
        return movieRepository.findAllMoviesByMovieRate(movieRate);
    }


}