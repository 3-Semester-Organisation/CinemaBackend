package godevenner.cinemabackend.movie.dto;

import godevenner.cinemabackend.enums.Genre;

import java.util.List;

public record RequestMovie(
        String title,
        String description,
        List<Genre> genre,
        String thumbnail,
        String rating
) {
}
