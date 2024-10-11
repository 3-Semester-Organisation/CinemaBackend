package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.showing.model.Showing;
import godevenner.cinemabackend.theatre.model.Theatre;
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
    List<Showing> findLatestShowingByTheatreId(long theatreId); //TODO Måske navnet på metode skal ændres. Lyder som om den returnerer et set med kun én showing, hvilket ikke er tilfældet.
}
