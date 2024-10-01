package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.movie.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ShowingRestController {

    private final ShowingService showingService;

    public ShowingRestController(ShowingService showingService) {
        this.showingService = showingService;
    }

    @GetMapping("/showings")
    public ResponseEntity<Set<ShowingDto>> getAllShowingsByMovie (@RequestBody Movie movie) {
        Set<ShowingDto> showingSet = showingService.getAllShowingsByMovie(movie);

        if (showingSet.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(showingSet);
    }
}
