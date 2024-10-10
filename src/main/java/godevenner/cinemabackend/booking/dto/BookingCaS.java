package godevenner.cinemabackend.booking.dto;

import godevenner.cinemabackend.costumer.Costumer;
import godevenner.cinemabackend.showing.model.Showing;

public record BookingCaS(
        long id,
        Showing showing,
        Costumer costumer
) {

}
