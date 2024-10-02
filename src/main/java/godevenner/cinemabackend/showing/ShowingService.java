package godevenner.cinemabackend.showing;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShowingService {

    private final ShowingRepository showingRepository;
    private final RequestShowingByMovieTitleMapper requestShowingByMovieTitleMapper;
    private final RequestAllShowingsMapper requestAllShowingsMapper;

    public ShowingService(ShowingRepository showingRepository,
                          RequestShowingByMovieTitleMapper requestShowingByMovieTitleMapper,
                          RequestAllShowingsMapper requestAllShowingsMapper) {
        this.showingRepository = showingRepository;
        this.requestShowingByMovieTitleMapper = requestShowingByMovieTitleMapper;
        this.requestAllShowingsMapper = requestAllShowingsMapper;
    }

    public Set<RequestShowingByMovieTitle> getAllShowingsByMovieTitle(String movieTitle) {
        Set<Showing> showingSet = showingRepository.getAllByMovieTitle(movieTitle);
        return showingSet.stream()
                .map(requestShowingByMovieTitleMapper)
                .collect(Collectors.toSet());
    }

    public List<RequestAllShowings> getAllShowings() {
        List<Showing> showingList = showingRepository.findAll();
        return showingList.stream()
                .map(requestAllShowingsMapper)
                .collect(Collectors.toList());
    }
}
