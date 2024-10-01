package godevenner.cinemabackend.booking;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SeatBookingRestController {


    @PostMapping("/seatbooking")
    public ResponseEntity<SeatBooking> createSeatBooking(@RequestBody SeatBooking seatBooking) {

        long bookingId = seatBooking.getBookingId();
        boolean doesExists  = BookingRepository.exsistsById(bookingId);

        if (doesExists) {
            return ResponseEntity.badRequest().build();
        }

        SeatBooking bookedSeats = SeatBookingRepository.save(seatBooking);
        return ResponseEntity.ok(bookedSeats);
    }
}
