package godevenner.cinemabackend.booking.service;

import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.model.SeatBooking;

import java.util.List;

public interface BookingApiService {

    List<Booking> getBookings();
    List<SeatBooking> getSeatBookings();
    List<Booking> getAllBookingsByShowingId(long id);
}
