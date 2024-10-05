package godevenner.cinemabackend.showing.mapper;

import godevenner.cinemabackend.showing.Showing;
import godevenner.cinemabackend.showing.dto.RequestShowing;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestShowingMapper implements Function<Showing, RequestShowing> {

    @Override
    public RequestShowing apply(Showing showing) {
        return new RequestShowing(
                showing.getId(),
                showing.getTheatre(),
                showing.getMovie(),
                showing.getStartTime()
        );
    }
}
