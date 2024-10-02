package godevenner.cinemabackend.showing;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShowingService {

    private final ShowingRepository showingRepository;
    private final RequestShowingByMovieTitleMapper requestShowingByMovieTitleMapper;
    private final RequestShowingsMapper requestShowingsMapper;

    public ShowingService(ShowingRepository showingRepository,
                          RequestShowingByMovieTitleMapper requestShowingByMovieTitleMapper,
                          RequestShowingsMapper requestShowingsMapper) {
        this.showingRepository = showingRepository;
        this.requestShowingByMovieTitleMapper = requestShowingByMovieTitleMapper;
        this.requestShowingsMapper = requestShowingsMapper;
    }

    public Set<RequestShowings> getAllShowingsByMovieTitle(String movieTitle) {
        Set<Showing> showingSet = showingRepository.getAllByMovieTitle(movieTitle);
        return showingSet.stream()
                .map(requestShowingsMapper)
                .collect(Collectors.toSet());
    }

    public List<RequestShowings> getAllShowings() {
        List<Showing> showingList = showingRepository.findAll();
        return showingList.stream()
                .map(requestShowingsMapper)
                .collect(Collectors.toList());
    }
}
