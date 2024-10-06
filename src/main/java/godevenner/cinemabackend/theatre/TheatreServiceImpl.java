package godevenner.cinemabackend.theatre;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;
    private final RequestTheatreMapper requestTheatreMapper;

    public TheatreServiceImpl(TheatreRepository theatreRepository, RequestTheatreMapper requestTheatreMapper) {
        this.theatreRepository = theatreRepository;
        this.requestTheatreMapper = requestTheatreMapper;
    }


    @Override
    public Optional<Set<RequestTheatre>> getAllTheatres() {
        List<Theatre> theatreList = theatreRepository.findAll();
        return Optional.of(
                theatreList
                        .stream()
                        .map(requestTheatreMapper)
                        .collect(Collectors.toSet()));
    }
}
