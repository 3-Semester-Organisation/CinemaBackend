package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.movie.Movie;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PostShowingMapper implements Function<PostShowing, Showing> {

    @Override
    public Showing apply(PostShowing postShowing) {
        return new Showing(
                postShowing.theatre(),

                new Movie(postShowing.movieId()),

                postShowing.scheduledStart(),
                postShowing.isCanceled()
        );
    }
}
