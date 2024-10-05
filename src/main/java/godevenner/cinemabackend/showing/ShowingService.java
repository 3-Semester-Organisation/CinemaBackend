package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.showing.dto.PostShowing;
import godevenner.cinemabackend.showing.dto.RequestShowing;

import java.util.List;
import java.util.Set;

public interface ShowingService {
    List<RequestShowing> getAllShowings();
    Set<RequestShowing> getAllShowingsByMovieId(long id);

    RequestShowing createShowing(PostShowing showing);

    boolean doesExist(PostShowing showing);
}
