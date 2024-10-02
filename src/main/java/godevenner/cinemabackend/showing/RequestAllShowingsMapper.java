package godevenner.cinemabackend.showing;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestAllShowingsMapper implements Function<Showing, RequestAllShowings> {

    @Override
    public RequestAllShowings apply(Showing showing) {
        return new RequestAllShowings(
                showing.getId(),
                showing.getTheatre(),
                showing.getMovie(),
                showing.getStartTime()
        );
    }
}
