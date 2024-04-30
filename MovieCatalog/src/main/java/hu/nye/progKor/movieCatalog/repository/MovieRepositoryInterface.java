package hu.nye.progKor.movieCatalog.repository;

import hu.nye.progKor.movieCatalog.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepositoryInterface extends CrudRepository<MovieEntity, Long> {

    List<MovieEntity> findAllMoviesByMovieRate(int movieRate);
}
