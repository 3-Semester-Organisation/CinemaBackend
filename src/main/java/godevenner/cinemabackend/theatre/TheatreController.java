package godevenner.cinemabackend.theatre;

import godevenner.cinemabackend.theatre.model.TheatreLayout;
import godevenner.cinemabackend.theatre.model.TheatreSeat;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1")
@RestController
public class TheatreController {
    private final TheatreService theatreService;

    @GetMapping("/theatre/{id}/layouts")
    public ResponseEntity<Set<TheatreLayout>> getTheatreLayouts(@PathVariable int id) {
        return ResponseEntity.ok(theatreService.getLayoutsByTheatreId(id));
    }

    @GetMapping("/theatre/{id}/seats")
    public ResponseEntity<Set<TheatreSeat>> getTheatreSeats(@PathVariable int id) {
        return ResponseEntity.ok(theatreService.getSeatsByTheatreId(id));
    }
}
