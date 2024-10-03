package godevenner.cinemabackend.showing.dto;

import godevenner.cinemabackend.theatre.model.Theatre;

import java.time.LocalDateTime;

public record PostShowing(
        Theatre theatre,
        long movieId,
        LocalDateTime startTime
) {
}
