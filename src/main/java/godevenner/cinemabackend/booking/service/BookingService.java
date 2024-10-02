package godevenner.cinemabackend.booking.service;

import godevenner.cinemabackend.booking.dto.BookingCaS;
import godevenner.cinemabackend.booking.dto.BookingRequest;
import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.model.SeatBooking;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    List<Booking> getBookings();

    // using DTO instead of model
    List<BookingCaS> getAllBookingsByShowingId(long id);

    Optional<Booking> getBooking(long id);
    ResponseEntity<Booking> createBooking(Booking booking);
    ResponseEntity<Booking> updateBooking(long id, Booking booking);
    ResponseEntity<Void> deleteBooking(long id);
    List<SeatBooking> getSeatBookings();
    List<SeatBooking> getAllSeatBookingsByBookingId(long id);
    Optional<SeatBooking> getSeatBooking(long id);
    Booking createSeatBooking(BookingRequest booking);
    ResponseEntity<SeatBooking> updateSeatBooking(long id, SeatBooking seatBooking);
    ResponseEntity<Void> deleteSeatBooking(long id);


}
