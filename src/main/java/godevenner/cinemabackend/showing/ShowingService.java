package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.movie.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShowingService {

    private final ShowingRepository showingRepository;
    private final ShowingMapper showingMapper;

    public ShowingService(ShowingRepository showingRepository, ShowingMapper showingMapper) {
        this.showingRepository = showingRepository;
        this.showingMapper = showingMapper;
    }

    public Set<ShowingDto> getAllShowingsByMovie(Movie movie) {
        Set<Showing> showingSet = showingRepository.getAllByMovie(movie);
        return showingSet.stream()
                .map(showingMapper)
                .collect(Collectors.toSet());
    }

    public List<ShowingDto> getAllShowings() {
        List<Showing> showingList = showingRepository.findAll();
        return showingList.stream()
                .map(showingMapper)
                .collect(Collectors.toList());
    }
}
