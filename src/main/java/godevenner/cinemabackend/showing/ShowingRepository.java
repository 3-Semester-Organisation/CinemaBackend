package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ShowingRepository extends JpaRepository<Showing, Long> {
    Set<Showing> getAllByMovie(Movie movie);
}
