package godevenner.cinemabackend.booking;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SeatBookingRestControllerOLD {

    /*

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

     */
}
