package godevenner.cinemabackend.booking.controller;

import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.model.SeatBooking;
import godevenner.cinemabackend.booking.repository.BookingRepository;
import godevenner.cinemabackend.booking.repository.SeatBookingRepository;
import godevenner.cinemabackend.booking.service.BookingApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class SeatBookingRestController {

    private final BookingApiService bookingApiService;
    private final SeatBookingRepository seatBookingRepository;

    @GetMapping("/seatbookings")
    public List<SeatBooking> getSeatBookings(@RequestParam long bookingId){
        return bookingApiService.getAllSeatBookingsByBookingId(bookingId);
    }
}
