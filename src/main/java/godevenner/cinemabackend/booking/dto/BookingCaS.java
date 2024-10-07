package godevenner.cinemabackend.booking.dto;

import godevenner.cinemabackend.customer.Customer;
import godevenner.cinemabackend.showing.model.Showing;

public record BookingCaS(
        long id,
        Showing showing,
        Customer customer
) {

}
