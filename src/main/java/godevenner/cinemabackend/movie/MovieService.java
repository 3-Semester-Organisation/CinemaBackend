package godevenner.cinemabackend.movie;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public Set<MovieDto> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(movieMapper).collect(Collectors.toSet());
    }

    public Set<MovieDto> getMoviesByAgeLimit (int maxAgeLimit) {
        List<Movie> movies = movieRepository.findAll();
        movies.removeIf(movie -> movie.getAgeLimit() > maxAgeLimit);
        return movies.stream().map(movieMapper).collect(Collectors.toSet());
    }

}
