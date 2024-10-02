package godevenner.cinemabackend.booking.dto;

import godevenner.cinemabackend.customer.Customer;
import godevenner.cinemabackend.showing.Showing;

public record BookingCaS(
        Showing showing,
        Customer customer
) {

}
