package godevenner.cinemabackend.movie.mapper;

import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.movie.dto.PostMovie;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PostMovieMapper implements Function<PostMovie, Movie> {

    @Override
    public Movie apply(PostMovie movie) {
        return new Movie(
                movie.title(),
                movie.description(),
                movie.genre(),
                movie.ageLimit(),
                movie.thumbnail()
        );
    }
}
