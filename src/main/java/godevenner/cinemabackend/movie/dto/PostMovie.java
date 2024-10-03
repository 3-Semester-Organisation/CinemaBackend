package godevenner.cinemabackend.movie.dto;

import godevenner.cinemabackend.enums.Genre;

import java.util.List;

public record PostMovie(
        String title,
        String description,
        Genre genre,
        int ageLimit,
        String thumbnail
) {
}
