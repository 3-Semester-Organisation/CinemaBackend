package godevenner.cinemabackend.movie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies") //All Movies
    public ResponseEntity<Set<MovieDto>> getAllMovies() {
        Set<MovieDto> movies = movieService.getAllMovies();
        if (movies.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(movies);
    }

@GetMapping("/movies") //Movies under certain age
    public ResponseEntity<Set<MovieDto>> getMoviesByAge(@RequestParam int age) {
        Set<MovieDto> movies = movieService.getMoviesByAgeLimit(age);
        if (movies.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(movies);
    }


}
