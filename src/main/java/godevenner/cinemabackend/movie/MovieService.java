package godevenner.cinemabackend.movie;

import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.movie.dto.PostMovie;
import godevenner.cinemabackend.movie.dto.RequestMovie;
import godevenner.cinemabackend.movie.mapper.PostMovieMapper;
import godevenner.cinemabackend.movie.mapper.RequestMovieMapper;
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

    private List<Movie> getActiveMovies() {
        List<Movie> movies = movieRepository.findAll();
        movies.removeIf(movie -> !movie.isActive());
        return movies;
    }

    // not used??
    public Set<RequestMovie> getAllMovies() {
        List<Movie> movies = getActiveMovies();
        return movies.stream()
                .map(requestMovieMapper)
                .collect(Collectors.toSet());
    }

    public Set<RequestMovie> getFilteredMovies(Genre genre, Integer maxAgeLimit) {
        List<Movie> movies = getActiveMovies();

        return movies.stream()
                .filter(movie -> genre == null || movie.getGenre() == genre)
                .filter(movie -> maxAgeLimit == null || movie.getAgeLimit() <= maxAgeLimit)
                .map(requestMovieMapper)
                .collect(Collectors.toSet());
    }

    public Set<Genre> getAllGenres() {
        List<Movie> movies = getActiveMovies();
        return movies.stream()
                .map(Movie::getGenre)
                .collect(Collectors.toSet());
    }
}