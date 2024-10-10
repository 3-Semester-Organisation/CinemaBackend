package godevenner.cinemabackend.booking.dto;

import java.util.List;

public record BookingRequest(
        Long showingId,
        String email,
        List<SeatRowData> bookedSeats
) {
}
