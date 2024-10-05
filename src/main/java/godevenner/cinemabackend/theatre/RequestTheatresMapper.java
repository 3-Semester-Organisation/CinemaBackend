package godevenner.cinemabackend.theatre;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestTheatresMapper implements Function<Theatre, RequestTheatres> {

    @Override
    public RequestTheatres apply(Theatre theatre) {
        return new RequestTheatres(
                theatre.getId(),
                theatre.getName()
        );
    }
}
