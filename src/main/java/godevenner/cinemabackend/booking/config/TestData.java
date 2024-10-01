package godevenner.cinemabackend.booking.config;


import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.repository.BookingRepository;
import godevenner.cinemabackend.booking.service.BookingApiService;
import godevenner.cinemabackend.costumer.Costumer;
import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.showing.Showing;
import godevenner.cinemabackend.theatre.Theatre;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class TestData implements CommandLineRunner {
    private final BookingRepository bookingRepository;

    @Override
    public void run(String... args) throws Exception {

        Set<Booking> bookings = new HashSet<>();
        Theatre theatre = new Theatre();
        Movie movie = new Movie();
        Costumer costumer = new Costumer();

        Showing showing = new Showing();
        showing.setTheatre(theatre);
        showing.setMovie(movie);

        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        Booking booking3 = new Booking();
        Booking booking4 = new Booking();

        booking1.setShowing(showing);
        booking2.setShowing(showing);
        booking3.setShowing(showing);
        booking4.setShowing(showing);
        booking1.setCostumer(costumer);
        booking2.setCostumer(costumer);
        booking3.setCostumer(costumer);
        booking4.setCostumer(costumer);

        bookings.add(booking1);
        bookings.add(booking2);
        bookings.add(booking3);
        bookings.add(booking4);



        bookingRepository.saveAll(bookings);

    }
}
