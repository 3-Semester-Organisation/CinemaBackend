package godevenner.cinemabackend.movie;

import godevenner.cinemabackend.showing.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {


}
