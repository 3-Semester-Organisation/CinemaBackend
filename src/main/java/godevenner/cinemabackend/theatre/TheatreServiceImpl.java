package godevenner.cinemabackend.theatre;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;
    private final RequestTheatresMapper requestTheatresMapper;

    public TheatreServiceImpl(TheatreRepository theatreRepository, RequestTheatresMapper requestTheatresMapper) {
        this.theatreRepository = theatreRepository;
        this.requestTheatresMapper = requestTheatresMapper;
    }


    @Override
    public Optional<Set<RequestTheatres>> getAllTheatres() {
        List<Theatre> theatreList = theatreRepository.findAll();
        return Optional.of(
                theatreList
                        .stream()
                        .map(requestTheatresMapper)
                        .collect(Collectors.toSet()));
    }
}
