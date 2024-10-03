package godevenner.cinemabackend.showing;

import java.util.List;
import java.util.Set;

public interface ShowingService {
    List<RequestShowings> getAllShowings();
    Set<RequestShowings> getAllShowingsByMovieTitle(String movieTitle);

    RequestShowings createShowing(PostShowing showing);
}
