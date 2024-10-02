package godevenner.cinemabackend.booking.mapper;

import godevenner.cinemabackend.booking.dto.BookingRequest;
import godevenner.cinemabackend.booking.model.Booking;
import org.springframework.stereotype.Component;

import java.util.function.Function;

// this bit is only here to not crash the program
@Component
public class BookingRequestMapper {


    public Booking apply(BookingRequest booking) {
        return null;
    }
}


// commented out for now, can't call booking.getBookedSeats()
/*
@Component
public class BookingRequestMapper implements Function<Booking, BookingRequest> {

    @Override
    public BookingRequest apply(Booking booking) {
        return new BookingRequest(
                booking.getShowing(),
                booking.getCustomer(),
                booking.getBookedSeats()
        );
    }

 */



