package godevenner.cinemabackend.movie;

import org.springframework.stereotype.Component;

import java.util.function.Function;

    @Component
    public class MovieMapper implements Function<Movie, MovieDto> {

        @Override
        public MovieDto apply(Movie movie) {
            return new MovieDto(
                    movie.getTitle(),
                    movie.getGenre(),
                    movie.getAgeLimit(),
                    movie.getShowingSet(),
                    movie.isActive(),
                    movie.getThumbnail()
            );
        }
    }

