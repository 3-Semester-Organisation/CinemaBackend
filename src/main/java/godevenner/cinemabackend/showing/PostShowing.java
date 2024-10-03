package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.movie.MovieDto;
import godevenner.cinemabackend.theatre.Theatre;

import java.time.LocalDateTime;

public record PostShowing(
        Theatre theatre,
        long movieId,
        LocalDateTime scheduledStart,
        boolean isCanceled
) {
}
