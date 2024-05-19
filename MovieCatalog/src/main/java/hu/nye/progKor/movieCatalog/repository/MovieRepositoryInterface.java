package hu.nye.progKor.movieCatalog.repository;

import java.util.List;

import hu.nye.progKor.movieCatalog.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepositoryInterface extends CrudRepository<MovieEntity, Long> {

    List<MovieEntity> findAllMoviesByMovieRate(int movieRate);

    List<MovieEntity> findAllMoviesByReleasedYear(int releasedYear);

    List<MovieEntity> findAllMoviesByMovieType(String movieType);

    List<MovieEntity> findAllMoviesByLengthInSeconds(int lengthInSeconds);

}
