package godevenner.cinemabackend.booking.dto;

import godevenner.cinemabackend.booking.model.SeatBooking;
import godevenner.cinemabackend.customer.Customer;
import godevenner.cinemabackend.showing.model.Showing;

import java.util.List;

public record BookingRequest(
        Long showingId,
        String email,
        List<SeatRowData> bookedSeats
) {
}
