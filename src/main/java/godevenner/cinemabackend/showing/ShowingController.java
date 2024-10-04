package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.showing.dto.PostShowing;
import godevenner.cinemabackend.showing.dto.RequestShowings;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/showing")
@CrossOrigin
public class ShowingController {

    private final ShowingService showingService;

    public ShowingController(ShowingServiceImpl showingService) {
        this.showingService = showingService;
    }

    @GetMapping("s")
    public ResponseEntity<Set<RequestShowings>> getAllShowingsByMovieTitle (@RequestParam String title) {
        Set<RequestShowings> showingSet = showingService.getAllShowingsByMovieTitle(title);

        if (showingSet.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(showingSet);
    }

    @GetMapping("s/all")
    public ResponseEntity<List<RequestShowings>> getAllShowings() {
        List<RequestShowings> showingList = showingService.getAllShowings();

        if (showingList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(showingList);
    }

    @PostMapping("")
    public ResponseEntity<RequestShowings> createShowing(@RequestBody PostShowing showing) {

        boolean doesExist = showingService.doesExist(showing);
        if (doesExist) {
            return ResponseEntity.badRequest().build();
        }

        RequestShowings postedShowing = showingService.createShowing(showing);
        return ResponseEntity.ok(postedShowing);
    }
}
