package godevenner.cinemabackend.movie.dto;

import godevenner.cinemabackend.enums.Genre;

public record RequestMovie(
        String title,
        String description,
        Genre genre,
        String thumbnail,
        String rating
) {
}
