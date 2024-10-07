package godevenner.cinemabackend.util;

import godevenner.cinemabackend.enums.Genre;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenreConverter {

    // used for converting string from json to list of genre enums
    public static List<Genre> convertStringToGenreList(String genres) {
        return Arrays.stream(genres.split(","))
                .map(String::trim)
                .map(genre -> genre.replace("-", ""))
                .map(String::toUpperCase)
                .map(Genre::valueOf)
                .collect(Collectors.toList());
    }
}