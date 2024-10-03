package godevenner.cinemabackend.movie.mapper;

import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.movie.dto.RequestMovie;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestMovieMapper implements Function<Movie, RequestMovie> {

    @Override
    public RequestMovie apply(Movie movie) {
        return new RequestMovie(
                movie.getTitle(),
                movie.getDescription(),
                movie.getGenreList(),
                movie.getThumbnail(),
                movie.getRating()
        );
    }


}
