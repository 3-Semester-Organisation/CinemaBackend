package godevenner.cinemabackend.theatre;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class TheatreController {

    private final TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping("/theatres/all")
    public ResponseEntity<Set<Theatre>> getAllTheatres() {
        Optional<Set<Theatre>> theatresOptional = theatreService.getAllTheatres();

        if (theatresOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Set<Theatre> theatresSet = theatresOptional.get();
        return ResponseEntity.ok(theatresSet);
    }
}
