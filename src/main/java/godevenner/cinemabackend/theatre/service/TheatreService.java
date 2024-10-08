package godevenner.cinemabackend.theatre.service;

import godevenner.cinemabackend.theatre.RequestTheatre;
import godevenner.cinemabackend.theatre.model.TheatreLayout;
import godevenner.cinemabackend.theatre.model.TheatreSeat;

import java.util.Optional;
import java.util.Set;

public interface TheatreService {

    Set<TheatreSeat> getSeatsByTheatreId(long id);
    Set<TheatreLayout> getLayoutsByTheatreId(long id);
    Optional<Set<RequestTheatre>> getAllTheatres();
}
