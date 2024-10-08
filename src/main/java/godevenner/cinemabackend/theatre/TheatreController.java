package godevenner.cinemabackend.theatre;

import godevenner.cinemabackend.theatre.model.TheatreLayout;
import godevenner.cinemabackend.theatre.model.TheatreSeat;
import godevenner.cinemabackend.theatre.service.TheatreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
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

    @GetMapping("/theatres/all")
    public ResponseEntity<Set<RequestTheatre>> getAllTheatres() {
        Optional<Set<RequestTheatre>> theatresOptional = theatreService.getAllTheatres();

        if (theatresOptional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Set<RequestTheatre> theatresSet = theatresOptional.get();
        return ResponseEntity.ok(theatresSet);
    }
}
