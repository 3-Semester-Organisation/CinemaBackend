package godevenner.cinemabackend.showing.dto;

import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.theatre.Theatre;

import java.time.LocalDateTime;

public record RequestShowing(
        long id,
        Theatre theatre,
        Movie movie,
        LocalDateTime startTime
) {
}
