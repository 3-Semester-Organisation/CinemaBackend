package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.booking.model.SeatBooking;
import godevenner.cinemabackend.booking.service.BookingService;
import godevenner.cinemabackend.showing.dto.PostShowing;
import godevenner.cinemabackend.showing.dto.RequestShowings;
import godevenner.cinemabackend.showing.mapper.PostShowingMapper;
import godevenner.cinemabackend.showing.mapper.RequestShowingsMapper;
import godevenner.cinemabackend.showing.model.SeatMap;
import godevenner.cinemabackend.showing.model.Showing;
import godevenner.cinemabackend.theatre.TheatreService;
import godevenner.cinemabackend.theatre.model.TheatreSeat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShowingServiceImpl implements ShowingService{

    private final ShowingRepository showingRepository;
    private final RequestShowingsMapper requestShowingsMapper;
    private final PostShowingMapper postShowingMapper;
    private final BookingService bookingService;
    private final TheatreService theatreService;

    @Override
    public Set<RequestShowings> getAllShowingsByMovieTitle(String movieTitle) {
        Set<Showing> showingSet = showingRepository.getAllByMovieTitle(movieTitle);
        return showingSet.stream()
                .map(requestShowingsMapper)
                .collect(Collectors.toSet());
    }

    @Override
    public List<RequestShowings> getAllShowings() {
        List<Showing> showingList = showingRepository.findAll();
        return showingList.stream()
                .map(requestShowingsMapper)
                .collect(Collectors.toList());
    }

    @Override
    public RequestShowings createShowing(PostShowing showing) {
        Showing newShowing = postShowingMapper.apply(showing);
        Showing createdShowing = showingRepository.save(newShowing);

        return requestShowingsMapper.apply(createdShowing);
    }

    @Override
    public boolean doesExist(PostShowing showing) {
        Showing needsCheck = postShowingMapper.apply(showing);
        return showingRepository.existsByTheatreAndStartTime(needsCheck.getTheatre(), needsCheck.getStartTime());
    }

    @Override
    public SeatMap getSeatMap(long showingId) {
        long theatreId;
        Optional<Showing> showingOptional = showingRepository.findById(showingId);
        if (showingOptional.isEmpty()) {
            throw new RuntimeException("Showing with id " + showingId + " not found");
        }
        Showing showing = showingOptional.get();
        theatreId = showing.getTheatre().getId();
        Set<TheatreSeat> seats = theatreService.getSeatsByTheatreId(theatreId);
        List<SeatBooking> bookings = bookingService.getAllSeatBookingsByShowingId(showingId);
        return new SeatMap(bookings, seats);
    }
}