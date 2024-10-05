package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.showing.dto.PostShowing;
import godevenner.cinemabackend.showing.dto.RequestShowings;
import godevenner.cinemabackend.showing.model.SeatMap;

import java.util.List;
import java.util.Set;

public interface ShowingService {
    List<RequestShowings> getAllShowings();
    Set<RequestShowings> getAllShowingsByMovieTitle(String movieTitle);

    RequestShowings createShowing(PostShowing showing);

    boolean doesExist(PostShowing showing);

    SeatMap getSeatMap(long showingId);
}
