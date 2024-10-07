package godevenner.cinemabackend.showing.mapper;

import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.movie.MovieRepository;
import godevenner.cinemabackend.showing.model.Showing;
import godevenner.cinemabackend.showing.dto.PostShowing;
import godevenner.cinemabackend.theatre.model.Theatre;
import godevenner.cinemabackend.theatre.TheatreRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class PostShowingMapper implements Function<PostShowing, Showing> {

    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;
    public PostShowingMapper(MovieRepository movieRepository, TheatreRepository theatreRepository) {
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
    }

    @Override
    public Showing apply(PostShowing postShowing) {
        //solves the detached entity problem
        Optional<Movie> optionalMovie = movieRepository.findById(postShowing.movieId());
        Movie movie = optionalMovie.get();

        Optional<Theatre> optionalTheatre = theatreRepository.findById(postShowing.theatreId());
        Theatre theatre = optionalTheatre.get();

        return new Showing(
                theatre,
                movie,
                postShowing.startTime()
        );
    }
}
