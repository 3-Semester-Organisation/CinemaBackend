package godevenner.cinemabackend.booking.dto;

import godevenner.cinemabackend.booking.model.SeatBooking;
import godevenner.cinemabackend.customer.Customer;
import godevenner.cinemabackend.showing.Showing;

import java.util.List;

public record BookingRequest(
        Showing showing,
        Customer customer,
        List<SeatBooking> bookedSeats
) {
}
