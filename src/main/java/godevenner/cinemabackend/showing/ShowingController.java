package godevenner.cinemabackend.showing;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ShowingController {

    private final ShowingService showingService;

    public ShowingController(ShowingServiceImpl showingService) {
        this.showingService = showingService;
    }

    @GetMapping("/showings")
    public ResponseEntity<Set<RequestShowings>> getAllShowingsByMovieTitle (@RequestParam String title) {
        Set<RequestShowings> showingSet = showingService.getAllShowingsByMovieTitle(title);

        if (showingSet.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(showingSet);
    }

    @GetMapping("/allshowings")
    public ResponseEntity<List<RequestShowings>> getAllShowings() {
        List<RequestShowings> showingList = showingService.getAllShowings();

        if (showingList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(showingList);
    }

    @PostMapping("/showing")
    public ResponseEntity<RequestShowings> createShowing(@RequestBody PostShowing showing) {

        boolean doesExist = showingService.doesExist(showing);
        if (doesExist) {
            return ResponseEntity.badRequest().build();
        }

        RequestShowings postedShowing = showingService.createShowing(showing);
        return ResponseEntity.ok(postedShowing);
    }
}
