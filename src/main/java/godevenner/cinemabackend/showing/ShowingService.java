package godevenner.cinemabackend.showing;

import java.util.List;
import java.util.Set;

public interface ShowingService {
    List<RequestAllShowings> getAllShowings();
    Set<RequestShowingByMovieTitle> getAllShowingsByMovieTitle(String movieTitle);
}
