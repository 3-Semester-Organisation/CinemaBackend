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
    private final RequestAllShowingsMapper requestAllShowingsMapper;

    public ShowingService(ShowingRepository showingRepository,
                          ShowingMapper showingMapper,
                          RequestAllShowingsMapper requestAllShowingsMapper) {
        this.showingRepository = showingRepository;
        this.showingMapper = showingMapper;
        this.requestAllShowingsMapper = requestAllShowingsMapper;
    }

    public Set<ShowingDto> getAllShowingsByMovie(Movie movie) {
        Set<Showing> showingSet = showingRepository.getAllByMovie(movie);
        return showingSet.stream()
                .map(showingMapper)
                .collect(Collectors.toSet());
    }

    public Set<ShowingDto> getAllShowingsByTitle(String title) {
        Set<Showing> showingSet = showingRepository.getAllByMovieTitle(title);
        return showingSet.stream()
                .map(showingMapper)
                .collect(Collectors.toSet());
    }

    public List<RequestAllShowings> getAllShowings() {
        List<Showing> showingList = showingRepository.findAll();
        return showingList.stream()
                .map(requestAllShowingsMapper)
                .collect(Collectors.toList());
    }
}
