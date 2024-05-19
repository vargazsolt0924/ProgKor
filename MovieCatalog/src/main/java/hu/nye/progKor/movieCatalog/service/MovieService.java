package hu.nye.progKor.movieCatalog.service;

import java.util.List;

import hu.nye.progKor.movieCatalog.entity.MovieEntity;
import hu.nye.progKor.movieCatalog.exception.MovieNotFoundException;
import hu.nye.progKor.movieCatalog.repository.MovieRepositoryInterface;
import hu.nye.progKor.movieCatalog.request.MovieRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService implements MovieServiceInterface {

    @Autowired
    private MovieRepositoryInterface movieRepository;

    @Override
    public MovieEntity saveMovie(MovieRequest movieRequest) {
        if (movieRequest == null) {
            throw new IllegalArgumentException("Movie request cannot be null");
        }
        MovieEntity movieEntity = MovieEntity.builder()
                .title(movieRequest.getTitle())
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
        if (id == null || movieRequest == null) {
            throw new IllegalArgumentException("ID or movie request cannot be null");
        }
        MovieEntity movieEntity = movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
        movieEntity.setTitle(movieRequest.getTitle());
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

    @Override
    public List<MovieEntity> findAllMoviesByReleasedYear(int releasedYear) {
        return movieRepository.findAllMoviesByReleasedYear(releasedYear);
    }

    @Override
    public List<MovieEntity> findAllMoviesByMovieType(String movieType) {
        return movieRepository.findAllMoviesByMovieType(movieType);
    }

    @Override
    public List<MovieEntity> findAllMoviesByLengthInSeconds(int lengthInSeconds) {
        return movieRepository.findAllMoviesByLengthInSeconds(lengthInSeconds);
    }


}