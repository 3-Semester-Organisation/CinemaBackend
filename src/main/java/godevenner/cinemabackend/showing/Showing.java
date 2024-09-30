package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.movie.Movie;
import java.time.LocalDateTime;

public class Showing {

    private Movie movie;
    private LocalDateTime startTime; //LocalDateTime.of(1997,5,13,20,45);
    private boolean isCancelled;
}
