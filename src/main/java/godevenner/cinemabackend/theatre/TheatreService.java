package godevenner.cinemabackend.theatre;

import godevenner.cinemabackend.theatre.model.TheatreLayout;
import godevenner.cinemabackend.theatre.model.TheatreSeat;

import java.util.Set;

public interface TheatreService {

    Set<TheatreSeat> getSeatsByTheatreId(long id);
    Set<TheatreLayout> getLayoutsByTheatreId(long id);
}
