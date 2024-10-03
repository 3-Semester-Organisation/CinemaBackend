package godevenner.cinemabackend.movie.dto;

import godevenner.cinemabackend.enums.Genre;

import java.util.List;


public record MovieDto(long id,
                       String title,
                       String description,
                       List<Genre> genreList,
                       int ageLimit,
                       String thumbnail) {
}
