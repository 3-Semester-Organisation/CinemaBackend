package godevenner.cinemabackend.movie.mapper;

import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.movie.dto.PostMovie;
import godevenner.cinemabackend.util.GenreConverter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class PostMovieMapper implements Function<PostMovie, Movie> {

    @Override
    public Movie apply(PostMovie movie) {
        List<Genre> genres = GenreConverter.convertStringToGenreList(movie.genres()); // not sure if this is a bad idea :/
        return new Movie(
                movie.title(),
                movie.description(),
                genres,
                movie.ageLimit(),
                movie.thumbnail()
        );
    }
}
