package godevenner.cinemabackend.showing;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShowingServiceImpl implements ShowingService{

    private final ShowingRepository showingRepository;
    private final RequestShowingsMapper requestShowingsMapper;

    public ShowingServiceImpl(ShowingRepository showingRepository,
                              RequestShowingsMapper requestShowingsMapper) {
        this.showingRepository = showingRepository;
        this.requestShowingsMapper = requestShowingsMapper;
    }

    @Override
    public Set<RequestShowings> getAllShowingsByMovieTitle(String movieTitle) {
        Set<Showing> showingSet = showingRepository.getAllByMovieTitle(movieTitle);
        return showingSet.stream()
                .map(requestShowingsMapper)
                .collect(Collectors.toSet());
    }

    @Override
    public List<RequestShowings> getAllShowings() {
        List<Showing> showingList = showingRepository.findAll();
        return showingList.stream()
                .map(requestShowingsMapper)
                .collect(Collectors.toList());
    }
}
