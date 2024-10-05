package godevenner.cinemabackend.movie;

import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.movie.dto.PostMovie;
import godevenner.cinemabackend.movie.dto.RequestMovie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }



    @GetMapping("/filter")
    public ResponseEntity<Set<RequestMovie>> getFilteredMovies(
            @RequestParam(required = false) Genre genre,
            @RequestParam(required = false) Integer age) {
        Set<RequestMovie> movies = movieService.getFilteredMovies(genre, age);

        if (movies.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(movies);
    }

    @GetMapping
    public ResponseEntity<Set<RequestMovie>> getAllActiveMovies() {

        Set<RequestMovie> movies = movieService.getAllMovies();
        if (movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(movies);
    }


    @GetMapping("/genres")
    public ResponseEntity<Set<Genre>> getGenres() {
        Set<Genre> genres = movieService.getAllGenres();
        if (genres.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(genres);
    }




    @PostMapping("/addmovie")
    public ResponseEntity<RequestMovie> addMovieFromOmdb(@RequestBody PostMovie movie) {
        RequestMovie postedMovie = movieService.addMovie(movie);
        return ResponseEntity.ok(postedMovie);
    }

}
