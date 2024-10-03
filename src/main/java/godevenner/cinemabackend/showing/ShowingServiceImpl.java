package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.showing.dto.PostShowing;
import godevenner.cinemabackend.showing.dto.RequestShowings;
import godevenner.cinemabackend.showing.mapper.PostShowingMapper;
import godevenner.cinemabackend.showing.mapper.RequestShowingsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShowingServiceImpl implements ShowingService{

    private final ShowingRepository showingRepository;
    private final RequestShowingsMapper requestShowingsMapper;
    private final PostShowingMapper postShowingMapper;

    public ShowingServiceImpl(ShowingRepository showingRepository,
                              RequestShowingsMapper requestShowingsMapper, PostShowingMapper postShowingMapper) {
        this.showingRepository = showingRepository;
        this.requestShowingsMapper = requestShowingsMapper;
        this.postShowingMapper = postShowingMapper;
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

    @Override
    public RequestShowings createShowing(PostShowing showing) {
        Showing newShowing = postShowingMapper.apply(showing);
        Showing createdShowing = showingRepository.save(newShowing);

        return requestShowingsMapper.apply(createdShowing);
    }

    @Override
    public boolean doesExist(PostShowing showing) {
        Showing needsCheck = postShowingMapper.apply(showing);
        return showingRepository.existsByTheatreAndStartTime(needsCheck.getTheatre(), needsCheck.getStartTime());
    }
}