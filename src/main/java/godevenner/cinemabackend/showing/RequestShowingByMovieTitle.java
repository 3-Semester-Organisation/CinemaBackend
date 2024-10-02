package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.theatre.Theatre;

import java.time.LocalDateTime;

public record RequestShowingByMovieTitle(
        Theatre theatre,
        LocalDateTime startTime
        ) {
}
