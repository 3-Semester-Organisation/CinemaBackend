package godevenner.cinemabackend.booking.controller;

import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.model.SeatBooking;
import godevenner.cinemabackend.booking.service.BookingService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getBookings(@RequestParam long showingId){
        return bookingService.getAllBookingsByShowingId(showingId);
    }

    @GetMapping("/seatbookings")
    public List<SeatBooking> getSeatBookings(@RequestParam long bookingId){
        return bookingService.getAllSeatBookingsByBookingId(bookingId);
    }

    @PostMapping("/seatbooking")
    public ResponseEntity<SeatBooking> createSeatBooking(@RequestBody SeatBooking seatBooking) {

        long bookingId = seatBooking.getBooking().getId();
        boolean doesExists  = bookingService.existsById(bookingId);

        if (doesExists) {
            return ResponseEntity.badRequest().build();
        }

        SeatBooking bookedSeats = bookingService.createBooking(seatBooking);
        return ResponseEntity.ok(bookedSeats);
    }
}
