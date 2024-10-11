package godevenner.cinemabackend.movie;

import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.movie.dto.PostMovie;
import godevenner.cinemabackend.movie.dto.RequestMovie;
import godevenner.cinemabackend.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
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
    public ResponseEntity<List<RequestMovie>> getFilteredMovies(
            @RequestParam(required = false) Genre genre,
            @RequestParam(required = false) Integer age) {
        List<RequestMovie> movies = movieService.getFilteredMovies(genre, age);

        if (movies.isEmpty()) return ResponseEntity.noContent().build();
        else return ResponseEntity.ok(movies);
    }


    @GetMapping("")
    public ResponseEntity<List<RequestMovie>> getAllActiveMovies() {

        List<RequestMovie> movies = movieService.getActiveMovies();
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






    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addmovie")
    public ResponseEntity<RequestMovie> addMovieFromOmdb(@RequestBody PostMovie movie) {
        RequestMovie postedMovie = movieService.addMovie(movie);
        return ResponseEntity.ok(postedMovie);
    }






    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteMovie(@RequestParam Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/setactive")
    public ResponseEntity<Void> setActive(@RequestParam Long id, @RequestParam boolean isActive) {
        movieService.setActive(id, isActive);
        return ResponseEntity.noContent().build();
    }

}
