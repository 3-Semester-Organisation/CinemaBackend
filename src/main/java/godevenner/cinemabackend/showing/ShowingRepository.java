package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.theatre.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ShowingRepository extends JpaRepository<Showing, Long> {
    Set<Showing> getAllByMovieId(long id);
    boolean existsByTheatreAndStartTime(Theatre theatre, LocalDateTime startTime);


    //not the best method since a theatre can have aloooooot of showings over a larger time frame, might refactor later.
    @Query("SELECT s FROM Showing s WHERE s.theatre.id = :theatreId ORDER BY s.startTime DESC")
    Optional<List<Showing>> findLatestShowingByTheatreId(long theatreId);
}
