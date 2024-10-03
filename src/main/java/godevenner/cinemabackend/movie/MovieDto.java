package godevenner.cinemabackend.movie;

import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.showing.Showing;

import java.util.Set;

public record MovieDto(long id,
                       String title,
                       String description,
                       Genre genre,
                       int AgeLimit,
                       String thumbnail) {
}
