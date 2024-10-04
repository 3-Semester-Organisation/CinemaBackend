package godevenner.cinemabackend.theatre;

import godevenner.cinemabackend.theatre.model.Theatre;
import godevenner.cinemabackend.theatre.model.TheatreLayout;
import godevenner.cinemabackend.theatre.model.TheatreSeat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;

    @Override
    public Set<TheatreSeat> getSeatsByTheatreId(long id) {
        Optional<Theatre> theatreOptional = theatreRepository.findById(id);
        if (theatreOptional.isPresent()) {
            Theatre theatre = theatreOptional.get();
            return theatre.getTheatreSeats();
        }
        throw new RuntimeException("There is no theatre with id " + id);
    }

    @Override
    public Set<TheatreLayout> getLayoutsByTheatreId(long id) {
        Optional<Theatre> theatreOptional = theatreRepository.findById(id);
        if (theatreOptional.isPresent()) {
            Theatre theatre = theatreOptional.get();
            return theatre.getTheatreLayouts();
        }
        throw new RuntimeException("There is no theatre with id " + id);
    }
}
