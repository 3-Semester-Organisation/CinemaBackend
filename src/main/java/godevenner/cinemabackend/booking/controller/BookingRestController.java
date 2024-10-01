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
public class BookingRestController {

    private final BookingService bookingService;

    @GetMapping("/bookings")
    public List<Booking> getBookings(@RequestParam long showingId){
        return bookingService.getAllBookingsByShowingId(showingId);
    }

    @PostMapping("/booking")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        return bookingService.createBooking(booking);
    }

    @PutMapping("/booking/{id}")
    public ResponseEntity<Booking> createBooking(@PathVariable Long id,
                                                 @RequestBody Booking booking){
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/booking/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id){
        return bookingService.deleteBooking(id);
    }

    @GetMapping("/seatbookings")
    public List<SeatBooking> getSeatBookings(@RequestParam long bookingId){
        return bookingService.getAllSeatBookingsByBookingId(bookingId);
    }

    @PostMapping("/seatbooking")
    public ResponseEntity<SeatBooking> createSeatBooking(@RequestBody SeatBooking seatBooking) {
        //tror det her skal ligge i service-laget
        long bookingId = seatBooking.getBooking().getId();
        boolean doesExists  = bookingService.existsById(bookingId);

        if (doesExists) {
            return ResponseEntity.badRequest().build();
        }

        SeatBooking bookedSeats = bookingService.createSeatBooking(seatBooking);
        return ResponseEntity.ok(bookedSeats);
    }
}
