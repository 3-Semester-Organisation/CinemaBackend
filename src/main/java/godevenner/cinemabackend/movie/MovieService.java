package godevenner.cinemabackend.movie;

import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.movie.dto.MovieDto;
import godevenner.cinemabackend.movie.dto.PostMovie;
import godevenner.cinemabackend.movie.dto.RequestMovie;
import godevenner.cinemabackend.movie.mapper.MovieMapper;
import godevenner.cinemabackend.movie.mapper.PostMovieMapper;
import godevenner.cinemabackend.movie.mapper.RequestMovieMapper;
import godevenner.cinemabackend.showing.Showing;
import godevenner.cinemabackend.showing.dto.PostShowing;
import godevenner.cinemabackend.util.GenreConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final PostMovieMapper postMovieMapper;
    private final RequestMovieMapper requestMovieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper, PostMovieMapper postMovieMapper, RequestMovieMapper requestMovieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
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

    public Set<MovieDto> getAllMovies() {
        List<Movie> movies = getActiveMovies();
        return movies.stream().map(movieMapper).collect(Collectors.toSet());
    }

    public Set<MovieDto> getFilteredMovies(Genre genre, Integer maxAgeLimit) {
        List<Movie> movies = getActiveMovies();

        return movies.stream()
                .filter(movie -> genre == null || movie.getGenreList().stream().anyMatch(g -> g == genre))
                .filter(movie -> maxAgeLimit == null || movie.getAgeLimit() <= maxAgeLimit)
                .map(movieMapper)
                .collect(Collectors.toSet());
    }

    public Set<Genre> getAllGenres() {
        List<Movie> movies = getActiveMovies();
        return movies.stream()
                .flatMap(movie -> movie.getGenreList().stream())
                .collect(Collectors.toSet());
    }
}