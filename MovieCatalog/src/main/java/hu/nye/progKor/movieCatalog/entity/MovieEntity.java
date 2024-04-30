package hu.nye.progKor.movieCatalog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
