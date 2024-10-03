package godevenner.cinemabackend.showing.mapper;

import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.showing.Showing;
import godevenner.cinemabackend.showing.dto.PostShowing;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PostShowingMapper implements Function<PostShowing, Showing> {

    @Override
    public Showing apply(PostShowing postShowing) {
        return new Showing(
                postShowing.theatre(),

                new Movie(postShowing.movieId()),

                postShowing.scheduledStart()
        );
    }
}
