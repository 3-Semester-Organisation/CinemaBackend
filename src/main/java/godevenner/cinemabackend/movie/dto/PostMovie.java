package godevenner.cinemabackend.movie.dto;

import godevenner.cinemabackend.enums.Genre;

public record PostMovie(
        String title,
        String description,
        Genre genre,
        int ageLimit,
        String thumbnail
) {
}
