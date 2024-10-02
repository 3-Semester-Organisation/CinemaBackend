package godevenner.cinemabackend.movie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@CrossOrigin
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<Set<MovieDto>> getMovies(@RequestParam(required = false) Integer age) {
        Set<MovieDto> movies;
        if (age == null) movies = movieService.getAllMovies();
        else movies = movieService.getMoviesByAgeLimit(age);

        if (movies.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(movies);
    }

}
