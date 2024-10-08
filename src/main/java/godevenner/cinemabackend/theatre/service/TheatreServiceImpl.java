package godevenner.cinemabackend.theatre.service;

import godevenner.cinemabackend.theatre.RequestTheatre;
import godevenner.cinemabackend.theatre.RequestTheatreMapper;
import godevenner.cinemabackend.theatre.TheatreRepository;
import godevenner.cinemabackend.theatre.model.Theatre;
import godevenner.cinemabackend.theatre.model.TheatreLayout;
import godevenner.cinemabackend.theatre.model.TheatreSeat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;
    private final RequestTheatreMapper requestTheatreMapper;


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


    public Optional<Set<RequestTheatre>> getAllTheatres() {
        List<Theatre> theatreList = theatreRepository.findAll();
        return Optional.of(
                theatreList
                        .stream()
                        .map(requestTheatreMapper)
                        .collect(Collectors.toSet()));
    }
}
