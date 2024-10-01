package godevenner.cinemabackend.booking.controller;

import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.repository.BookingRepository;
import godevenner.cinemabackend.booking.service.BookingApiService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class BookingRestController {

    private final BookingApiService bookingApiService;
    private final BookingRepository bookingRepository;

    @GetMapping("/bookings")
    public List<Booking> getBookings(@RequestParam long showingId){
        return bookingApiService.getAllBookingsByShowingId(showingId);
    }
}
