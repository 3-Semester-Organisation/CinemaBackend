package godevenner.cinemabackend.movie;

import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.movie.dto.PostMovie;
import godevenner.cinemabackend.movie.dto.RequestMovie;
import godevenner.cinemabackend.movie.mapper.PostMovieMapper;
import godevenner.cinemabackend.movie.mapper.RequestMovieMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final PostMovieMapper postMovieMapper;
    private final RequestMovieMapper requestMovieMapper;

    private List<Movie> activeMovies = new ArrayList<>();
    private LocalDateTime lastMovieUpdate;


    public MovieService(MovieRepository movieRepository, PostMovieMapper postMovieMapper, RequestMovieMapper requestMovieMapper) {
        this.movieRepository = movieRepository;
        this.postMovieMapper = postMovieMapper;
        this.requestMovieMapper = requestMovieMapper;
    }

    private void cacheActiveMoviesIfNeeded() {
        if (lastMovieUpdate == null || Duration.between(lastMovieUpdate, LocalDateTime.now()).toMinutes() > 15) {
            activeMovies = movieRepository.findAllByIsActiveTrueOrderByTitle();
            lastMovieUpdate = LocalDateTime.now();
        }
    }
    private void cacheActiveMovies() { //Bruges efter add() og delete()
        activeMovies = movieRepository.findAllByIsActiveTrueOrderByTitle();
    }

    public List<RequestMovie> getActiveMovies() {
        cacheActiveMoviesIfNeeded();
        return activeMovies.stream()
                .map(requestMovieMapper)
                .collect(Collectors.toList());
    }




    public Set<Genre> getAllGenres() {
        cacheActiveMoviesIfNeeded();
        return activeMovies.stream()
                .flatMap(movie -> movie.getGenreList().stream())
                .collect(Collectors.toSet());
    }


    public List<RequestMovie> getFilteredMovies(Genre genre, Integer maxAgeLimit) {
        cacheActiveMoviesIfNeeded();

        return activeMovies.stream()
                .filter(movie -> genre == null || movie.getGenreList().stream().anyMatch(g -> g == genre))
                .filter(movie -> maxAgeLimit == null || movie.getAgeLimit() <= maxAgeLimit)
                .map(requestMovieMapper)
                .collect(Collectors.toList());
    }


    public RequestMovie addMovie(PostMovie movie) {
        Movie newMovie = postMovieMapper.apply(movie);
        newMovie.setActive(true); //TODO skal fjernes!! Men inactive movies vises ikke under Movies-tab
        Movie createdMovie = movieRepository.save(newMovie);
        cacheActiveMovies();
        return requestMovieMapper.apply(createdMovie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
        cacheActiveMovies();
    }

}