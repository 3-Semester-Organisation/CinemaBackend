package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.showing.dto.PostShowing;
import godevenner.cinemabackend.showing.dto.RequestShowings;

import java.util.List;
import java.util.Set;

public interface ShowingService {
    List<RequestShowings> getAllShowings();
    Set<RequestShowings> getAllShowingsByMovieId(long id);

    RequestShowings createShowing(PostShowing showing);

    boolean doesExist(PostShowing showing);
}
