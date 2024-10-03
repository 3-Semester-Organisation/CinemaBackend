package godevenner.cinemabackend.movie.mapper;

import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.movie.dto.MovieDto;
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
                    movie.getGenreList(),
                    movie.getAgeLimit(),
                    movie.getThumbnail()
            );
        }
    }

