package godevenner.cinemabackend.movie;

import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.movie.dto.PostMovie;
import godevenner.cinemabackend.movie.dto.RequestMovie;
import godevenner.cinemabackend.movie.mapper.PostMovieMapper;
import godevenner.cinemabackend.movie.mapper.RequestMovieMapper;
import godevenner.cinemabackend.showing.model.Showing;
import godevenner.cinemabackend.showing.dto.PostShowing;
import godevenner.cinemabackend.util.GenreConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final PostMovieMapper postMovieMapper;
    private final RequestMovieMapper requestMovieMapper;

    public MovieService(MovieRepository movieRepository, PostMovieMapper postMovieMapper, RequestMovieMapper requestMovieMapper) {
        this.movieRepository = movieRepository;
        this.postMovieMapper = postMovieMapper;
        this.requestMovieMapper = requestMovieMapper;
    }

    public RequestMovie addMovie(PostMovie movie) {
        Movie newMovie = postMovieMapper.apply(movie);
        newMovie.setActive(true); //TODO skal fjernes!! Men inactive movies vises ikke under Movies-tab
        Movie createdMovie = movieRepository.save(newMovie);

        return requestMovieMapper.apply(createdMovie);
    }

    //maybe this method should be public
    private List<Movie> getActiveMovies() {
        List<Movie> movies = movieRepository.findAll();
        movies.removeIf(movie -> !movie.isActive());
        return movies;
    }

    // not used?? //now in use 05-10-2024 //and this method should be actually getting all movies (also none active for admins and what not)?
    public Set<RequestMovie> getAllMovies() {
        List<Movie> movies = getActiveMovies();
        return movies.stream()
                .map(requestMovieMapper)
                .collect(Collectors.toSet());
    }

    public Set<RequestMovie> getFilteredMovies(Genre genre, Integer maxAgeLimit) {
        List<Movie> movies = getActiveMovies();

        return movies.stream()
                .filter(movie -> genre == null || movie.getGenreList().stream().anyMatch(g -> g == genre))
                .filter(movie -> maxAgeLimit == null || movie.getAgeLimit() <= maxAgeLimit)
                .map(requestMovieMapper)
                .collect(Collectors.toSet());
    }

    public Set<Genre> getAllGenres() {
        List<Movie> movies = getActiveMovies();
        return movies.stream()
                .flatMap(movie -> movie.getGenreList().stream())
                .collect(Collectors.toSet());
    }
}