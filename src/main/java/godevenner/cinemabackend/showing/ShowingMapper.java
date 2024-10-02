package godevenner.cinemabackend.showing;

import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

@Component
public class ShowingMapper implements Function<Showing, ShowingDto> {

    @Override
    public ShowingDto apply(Showing showing) {
        return new ShowingDto(
                showing.getTheatre(),
                showing.getMovie(),
                showing.getStartTime()
        );
    }
}
