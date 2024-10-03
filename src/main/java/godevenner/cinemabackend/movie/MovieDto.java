package godevenner.cinemabackend.movie;

import godevenner.cinemabackend.enums.Genre;




public record MovieDto(long id,
                       String title,
                       String description,
                       Genre genre,
                       int AgeLimit,
                       String thumbnail) {
}
