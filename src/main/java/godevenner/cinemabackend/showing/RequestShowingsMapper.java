package godevenner.cinemabackend.showing;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestShowingsMapper implements Function<Showing, RequestShowings> {

    @Override
    public RequestShowings apply(Showing showing) {
        return new RequestShowings(
                showing.getId(),
                showing.getTheatre(),
                showing.getMovie(),
                showing.getStartTime()
        );
    }
}
