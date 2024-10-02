package godevenner.cinemabackend.movie;
import godevenner.cinemabackend.enums.Genre;
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

    public Set<MovieDto> getFilteredMovies(Genre genre, Integer maxAgeLimit, Boolean isActive) {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream()
                .filter(movie -> genre == null || movie.getGenre() == genre)
                .filter(movie -> maxAgeLimit == null || movie.getAgeLimit() <= maxAgeLimit)
                .filter(movie -> isActive == null || movie.isActive() == isActive)
                .map(movieMapper)
                .collect(Collectors.toSet());
    }
}