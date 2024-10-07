package godevenner.cinemabackend.theatre;

import godevenner.cinemabackend.theatre.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
}
