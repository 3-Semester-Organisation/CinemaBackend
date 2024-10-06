package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.showing.dto.PostShowing;
import godevenner.cinemabackend.showing.dto.RequestShowing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



    @GetMapping("/showing")
    public ResponseEntity<RequestShowing> getLatestShowingByTheatreId(@RequestParam long theatreId) {
        RequestShowing latestShowing = showingService.getLatestShowingByTheatreId(theatreId);

        if (latestShowing == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(latestShowing);
    }


    @GetMapping("/showings")
    public ResponseEntity<Set<RequestShowing>> getAllShowingsByMovieId (@RequestParam long movieId) {
        Set<RequestShowing> showingSet = showingService.getAllShowingsByMovieId(movieId);

        if (showingSet.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(showingSet);
    }


    @GetMapping("/showings/all")
    public ResponseEntity<List<RequestShowing>> getAllShowings() {
        List<RequestShowing> showingList = showingService.getAllShowings();

        if (showingList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(showingList);
    }






    @PostMapping("/showing")
    public ResponseEntity<RequestShowing> createShowing(@RequestBody PostShowing showing) {

        boolean doesExist = showingService.doesExist(showing);
        if (doesExist) {
            return ResponseEntity.badRequest().build();
        }

        RequestShowing postedShowing = showingService.createShowing(showing);
        return ResponseEntity.ok(postedShowing);
    }
}