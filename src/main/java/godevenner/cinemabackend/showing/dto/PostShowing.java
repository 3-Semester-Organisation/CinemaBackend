package godevenner.cinemabackend.showing.dto;

import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.theatre.Theatre;

import java.time.LocalDateTime;

public record PostShowing(
        long theatreId,
        long movieId,
        LocalDateTime startTime
) {
}
