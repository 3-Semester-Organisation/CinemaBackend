package godevenner.cinemabackend.booking.mapper;

import godevenner.cinemabackend.booking.dto.BookingRequest;
import godevenner.cinemabackend.booking.model.Booking;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookingRequestMapper implements Function<BookingRequest, Booking> {
    @Override
    public Booking apply(BookingRequest bookingRequest) {
        return new Booking(
                bookingRequest.customer(),
                bookingRequest.showing()
        );
    }
}
