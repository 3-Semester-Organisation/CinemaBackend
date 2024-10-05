package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.showing.dto.PostShowing;
import godevenner.cinemabackend.showing.dto.RequestShowing;
import godevenner.cinemabackend.showing.mapper.PostShowingMapper;
import godevenner.cinemabackend.showing.mapper.RequestShowingMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShowingServiceImpl implements ShowingService{

    private final ShowingRepository showingRepository;
    private final RequestShowingMapper requestShowingMapper;
    private final PostShowingMapper postShowingMapper;

    public ShowingServiceImpl(ShowingRepository showingRepository,
                              RequestShowingMapper requestShowingMapper, PostShowingMapper postShowingMapper) {
        this.showingRepository = showingRepository;
        this.requestShowingMapper = requestShowingMapper;
        this.postShowingMapper = postShowingMapper;
    }


    @Override
    public RequestShowing getLatestShowingByTheatreId(long theatreId) {

        Optional<List<Showing>> optionalShowings = showingRepository.findLatestShowingByTheatreId(theatreId);
        if (optionalShowings.isEmpty()) {
            return null;
        }

        Showing latestShowing = optionalShowings.get().getFirst();
        return requestShowingMapper.apply(latestShowing);
    }


    @Override
    public Set<RequestShowing> getAllShowingsByMovieId(long movieId) {
        Set<Showing> showingSet = showingRepository.getAllByMovieId(movieId);
        return showingSet.stream()
                .map(requestShowingMapper)
                .collect(Collectors.toSet());
    }

    @Override
    public List<RequestShowing> getAllShowings() {
        List<Showing> showingList = showingRepository.findAll();
        return showingList.stream()
                .map(requestShowingMapper)
                .collect(Collectors.toList());
    }

    @Override
    public RequestShowing createShowing(PostShowing showing) {
        Showing newShowing = postShowingMapper.apply(showing);
        Showing createdShowing = showingRepository.save(newShowing);

        return requestShowingMapper.apply(createdShowing);
    }

    @Override
    public boolean doesExist(PostShowing showing) {
        Showing needsCheck = postShowingMapper.apply(showing);
        return showingRepository.existsByTheatreAndStartTime(needsCheck.getTheatre(), needsCheck.getStartTime());
    }
}