package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.theatre.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Set;

public interface ShowingRepository extends JpaRepository<Showing, Long> {
    Set<Showing> getAllByMovieTitle(String title);
    boolean existsByTheatreAndStartTime(Theatre theatre, LocalDateTime startTime);
}
