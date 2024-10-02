package godevenner.cinemabackend.movie;

import godevenner.cinemabackend.enums.Genre;
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
    public ResponseEntity<Set<MovieDto>> getMovies(
            @RequestParam(required = false) Genre genre,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) Boolean active) {
        Set<MovieDto> movies = movieService.getFilteredMovies(genre, age, active);

        if (movies.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(movies);
    }

}
