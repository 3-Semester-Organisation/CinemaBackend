package godevenner.cinemabackend.movie.dto;

public record PostMovie(
        String title,
        String description,
        String genres,
        int ageLimit,
        String thumbnail,
        String runtime
) {
}
