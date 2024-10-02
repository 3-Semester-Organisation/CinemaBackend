package godevenner.cinemabackend.showing;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RequestShowingByMovieTitleMapper implements Function<Showing, RequestShowingByMovieTitle> {

    @Override
    public RequestShowingByMovieTitle apply(Showing showing) {
        return new RequestShowingByMovieTitle(
                showing.getTheatre(),
                showing.getStartTime()
        );
    }
}
