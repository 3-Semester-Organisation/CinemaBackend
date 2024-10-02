package godevenner.cinemabackend.booking.mapper;

import godevenner.cinemabackend.booking.dto.BookingCaS;
import godevenner.cinemabackend.booking.model.Booking;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class BookingCaSMapper implements Function<Booking, BookingCaS> {

    @Override
    public BookingCaS apply(Booking booking) {
        return new BookingCaS(
                booking.getShowing(),
                booking.getCustomer()
        );
    }
}
