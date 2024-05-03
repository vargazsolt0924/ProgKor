package hu.nye.progKor.movieCatalog.service;

import hu.nye.progKor.movieCatalog.entity.MovieEntity;
import hu.nye.progKor.movieCatalog.exception.MovieNotFoundException;
import hu.nye.progKor.movieCatalog.repository.MovieRepositoryInterface;
import hu.nye.progKor.movieCatalog.request.MovieRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepositoryInterface movieRepositoryInterface;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveMovieShouldReallySaveMovie() {
        // GIVEN
        MovieRequest movieRequest = createMovieRequest();
        MovieEntity expectedMovie = createMovieEntity(movieRequest);

        when(movieRepositoryInterface.save(any())).thenReturn(expectedMovie);

        // WHEN
        MovieEntity result = movieService.saveMovie(movieRequest);

        // THEN
        assertEquals(expectedMovie, result);
        verify(movieRepositoryInterface, times(1)).save(any());
    }

    @Test
    public void getMovieByIdShouldReturnTheProperMovie() {
        // GIVEN
        Long id = 1L;
        MovieEntity expectedMovie = createMovieEntity(createMovieRequest());
        when(movieRepositoryInterface.findById(id)).thenReturn(Optional.ofNullable(expectedMovie));

        // WHEN
        MovieEntity result = movieService.getMovieById(id);

        // THEN
        assertEquals(expectedMovie, result);
    }

    @Test
    public void updateMovieShouldReallyTheProperMovie() {
        // GIVEN
        Long id = 1L;
        MovieRequest movieRequest = createMovieRequest();
        MovieEntity existingMovie = createMovieEntity(movieRequest);
        MovieEntity updatedMovie = createMovieEntity(movieRequest);
        updatedMovie.setTitle("Updated Title");

        when(movieRepositoryInterface.findById(id)).thenReturn(Optional.ofNullable(existingMovie));
        when(movieRepositoryInterface.save(any())).thenReturn(updatedMovie);

        // WHEN
        MovieEntity result = movieService.updateMovie(id, movieRequest);

        // THEN
        assertEquals(updatedMovie, result);
    }

    @Test
    public void deleteMovieByIdShouldReallyDeleteTheMovie() {
        // GIVEN
        Long id = 1L;

        // WHEN
        movieService.deleteMovieById(id);

        // THEN
        verify(movieRepositoryInterface).deleteById(id);
    }

    @Test
    public void findAllMoviesByMovieRateShouldReallyFindAllTheMovieByMovieRate() {
        // GIVEN
        int movieRate = 5;

        // WHEN
        movieService.findAllMoviesByMovieRate(movieRate);

        // THEN
        verify(movieRepositoryInterface).findAllMoviesByMovieRate(movieRate);
    }

    @Test
    public void getMovieByIdShouldThrowMovieNotFoundExceptionWhenMovieNotFound() {
        // GIVEN
        Long id = 1L;
        when(movieRepositoryInterface.findById(id)).thenReturn(Optional.empty());

        // WHEN & THEN
        assertThrows(MovieNotFoundException.class, () -> movieService.getMovieById(id));
    }

    @Test
    public void updateMovieShouldThrowExceptionWhenMovieNotFound() {
        // GIVEN
        Long id = 1L;
        MovieRequest movieRequest = createMovieRequest();

        // Mock the repository to return an empty Optional
        when(movieRepositoryInterface.findById(id)).thenReturn(Optional.empty());

        // WHEN & THEN
        assertThrows(MovieNotFoundException.class, () -> movieService.updateMovie(id, movieRequest));
    }

    @Test
    public void getMovieByIdShouldThrowExceptionWhenRepositoryThrowsException() {
        // GIVEN
        Long id = 1L;

        doThrow(new RuntimeException("Database error")).when(movieRepositoryInterface).findById(id);

        // WHEN & THEN
        assertThrows(RuntimeException.class, () -> movieService.getMovieById(id));
    }

    @Test
    public void findAllMoviesByMovieRateShouldReturnCorrectNumberOfMovies() {
        // GIVEN
        int movieRate = 5;
        List<MovieEntity> expectedMovies = new ArrayList<>(); // Populate this with expected movies

        // Mock the repository to return the expected list
        when(movieRepositoryInterface.findAllMoviesByMovieRate(movieRate)).thenReturn(expectedMovies);

        // WHEN
        List<MovieEntity> result = movieService.findAllMoviesByMovieRate(movieRate);

        // THEN
        assertEquals(expectedMovies.size(), result.size());
    }

    @Test
    public void saveMovieShouldThrowExceptionWhenInputIsNull() {
        // GIVEN
        MovieRequest movieRequest = null;

        // WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> movieService.saveMovie(movieRequest));
    }

    @Test
    public void updateMovieShouldThrowExceptionWhenInvalidParametersAreProvided() {
        // GIVEN
        Long invalidId = null;
        MovieRequest movieRequest = new MovieRequest(); // Assuming this is a valid constructor

        // WHEN & THEN
        assertThrows(IllegalArgumentException.class, () -> movieService.updateMovie(invalidId, movieRequest));
    }

    private MovieRequest createMovieRequest() {
        return MovieRequest.builder()
                .title("Test Movie")
                .directorName("Test Director")
                .movieRate(8)
                .releasedYear(2020)
                .movieType("Action")
                .description("A test movie")
                .lengthInSeconds(120)
                .build();
    }

    private MovieEntity createMovieEntity(MovieRequest movieRequest) {
        return MovieEntity.builder()
                .title(movieRequest.getTitle())
                .directorName(movieRequest.getDirectorName())
                .movieRate(movieRequest.getMovieRate())
                .releasedYear(movieRequest.getReleasedYear())
                .movieType(movieRequest.getMovieType())
                .description(movieRequest.getDescription())
                .lengthInSeconds(movieRequest.getLengthInSeconds())
                .build();
    }
}
