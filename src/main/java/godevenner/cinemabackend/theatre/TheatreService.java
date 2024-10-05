package godevenner.cinemabackend.theatre;

import java.util.Optional;
import java.util.Set;

public interface TheatreService {
    Optional<Set<RequestTheatre>> getAllTheatres();
}
