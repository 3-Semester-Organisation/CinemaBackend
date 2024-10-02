package godevenner.cinemabackend.movie;

import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.showing.Showing;

import java.util.Set;

public record MovieDto(String title,
                       Genre genre,
                       int AgeLimit,
                       Set<Showing> showingSet,
                       boolean isActive,
                       String thumbnail) {
}
