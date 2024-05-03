package hu.nye.progKor.movieCatalog.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MovieRequest {
    @NotEmpty
    private String title;

    @NotEmpty
    private String directorName;

    @PositiveOrZero
    private int movieRate;

    @PositiveOrZero
    private int releasedYear;

    @NotEmpty
    private String movieType;

    @NotEmpty
    private String description;

    @PositiveOrZero
    private int lengthInSeconds;
}
