package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.theatre.Theatre;

import java.time.LocalDateTime;

public record RequestShowings(
        Theatre theatre,
        Movie movie,
        LocalDateTime startTime
) {
}
