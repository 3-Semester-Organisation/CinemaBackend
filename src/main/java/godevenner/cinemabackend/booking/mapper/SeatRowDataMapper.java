package godevenner.cinemabackend.booking.mapper;

import godevenner.cinemabackend.booking.dto.SeatRowData;
import godevenner.cinemabackend.booking.model.SeatBooking;

import java.util.function.Function;

public class SeatRowDataMapper implements Function<SeatRowData, SeatBooking> {
    @Override
    public SeatBooking apply(SeatRowData seatRowData) {
        return new SeatBooking();
    }
}
