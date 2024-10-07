package godevenner.cinemabackend.movie.dto;

import godevenner.cinemabackend.enums.Genre;

import java.util.List;

public record RequestMovie(
        long id,
        String title,
        String description,
        List<Genre> genreList,
        int ageLimit,
        String thumbnail
) {
}
