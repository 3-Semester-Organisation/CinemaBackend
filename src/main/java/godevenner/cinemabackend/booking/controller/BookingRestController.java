package godevenner.cinemabackend.booking.controller;

import godevenner.cinemabackend.booking.dto.BookingCaS;
import godevenner.cinemabackend.booking.dto.BookingRequest;
import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.model.SeatBooking;
import godevenner.cinemabackend.booking.repository.SeatBookingRepository;
import godevenner.cinemabackend.booking.service.BookingService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookingRestController {

    private final BookingService bookingService;

    //BOOKING

    // commented out until seatbooking is functional
    /*
    @GetMapping("/bookings")
    public List<Booking> getBookings(@RequestParam long showingId){
        return bookingService.getAllBookingsByShowingId(showingId);
    }
    */

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/bookings")
    public List<BookingCaS> getBookings(@RequestParam long showingId){
        return bookingService.getAllBookingsByShowingId(showingId);
    }

    @PostMapping("/booking")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        return bookingService.createBooking(booking);
    }

    @PutMapping("/updatebooking/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id,
                                                 @RequestBody Booking booking){
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/deletebooking/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id){
        return bookingService.deleteBooking(id);
    }




    //SEATBOOKINGS
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/seatbookings")
    public List<SeatBooking> getSeatBookings(@RequestParam long bookingId){
        return bookingService.getAllSeatBookingsByBookingId(bookingId);
    }

    @GetMapping("/showing/{id}/seatbookings")
    public List<SeatBooking> getShowingSeatBookings(@PathVariable Long id){
        return bookingService.getAllSeatBookingsByShowingId(id);
    }

    @PostMapping("/seatbooking")
    public ResponseEntity<Booking> createSeatBooking(@RequestBody BookingRequest bookingRequest) {
        Booking bookedSeats = bookingService.createSeatBooking(bookingRequest);

        return ResponseEntity.ok(bookedSeats);
    }


    @PutMapping("/updateseatbooking/{id}")
    public ResponseEntity<SeatBooking> updateSeatBooking(@PathVariable Long id,
                                                 @RequestBody SeatBooking seatBooking){
        return bookingService.updateSeatBooking(id, seatBooking);
    }

    @DeleteMapping("/deleteseatbooking/{id}")
    public ResponseEntity<Void> deleteSeatBooking(@PathVariable Long id){
        return bookingService.deleteSeatBooking(id);
    }
}
