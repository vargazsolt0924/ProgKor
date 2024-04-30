package hu.nye.progKor.movieCatalog.model;

public class Movie {
    private String title;
    private String directorName;
    private int movieRate;
    private int releasedYear;
    private String movieType;
    private String description;
    private int lengthInSeconds;

    public Movie(String description, String directorName, int lengthInSeconds, int movieRate, String movieType, int releasedYear, String title) {
        this.description = description;
        this.directorName = directorName;
        this.lengthInSeconds = lengthInSeconds;
        this.movieRate = movieRate;
        this.movieType = movieType;
        this.releasedYear = releasedYear;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public int getMovieRate() {
        return movieRate;
    }

    public void setMovieRate(int movieRate) {
        this.movieRate = movieRate;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", directorName='" + directorName + '\'' +
                ", movieRate=" + movieRate +
                ", releasedYear=" + releasedYear +
                ", movieType='" + movieType + '\'' +
                ", lengthInSeconds=" + lengthInSeconds +
                '}';
    }
}
