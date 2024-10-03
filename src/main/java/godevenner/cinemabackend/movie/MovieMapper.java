package godevenner.cinemabackend.movie;

import org.springframework.stereotype.Component;

import java.util.function.Function;

    @Component
    public class MovieMapper implements Function<Movie, MovieDto> {

        @Override
        public MovieDto apply(Movie movie) {
            return new MovieDto(
                    movie.getId(),
                    movie.getTitle(),
                    movie.getDescription(),
                    movie.getGenre(),
                    movie.getAgeLimit(),
                    movie.getThumbnail()
            );
        }
    }

