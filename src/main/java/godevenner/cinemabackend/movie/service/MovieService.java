package godevenner.cinemabackend.movie.service;

import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.movie.dto.PostMovie;
import godevenner.cinemabackend.movie.dto.RequestMovie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface MovieService {

    RequestMovie addMovie(PostMovie movie);

    //maybe this method should be public
    List<RequestMovie> getActiveMovies();

    // not used?? //now in use 05-10-2024 //and this method should be actually getting all movies (also none active for admins and what not)?
    List<RequestMovie> getAllMovies();

    List<RequestMovie> getFilteredMovies(Genre genre, Integer maxAgeLimit);

    Set<Genre> getAllGenres();

    void deleteMovie(Long id);
}