package godevenner.cinemabackend.theatre;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestTheatreMapper implements Function<Theatre, RequestTheatre> {

    @Override
    public RequestTheatre apply(Theatre theatre) {
        return new RequestTheatre(
                theatre.getId(),
                theatre.getName()
        );
    }
}
