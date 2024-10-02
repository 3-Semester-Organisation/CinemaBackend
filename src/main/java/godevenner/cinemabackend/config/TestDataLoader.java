package godevenner.cinemabackend.config;

import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.model.SeatBooking;
import godevenner.cinemabackend.booking.repository.BookingRepository;
import godevenner.cinemabackend.booking.repository.SeatBookingRepository;
import godevenner.cinemabackend.customer.Customer;
import godevenner.cinemabackend.customer.CustomerRepository;
import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.showing.Showing;
import godevenner.cinemabackend.showing.ShowingRepository;
import godevenner.cinemabackend.theatre.Theatre;
import godevenner.cinemabackend.theatrelayout.TheatreLayout;
import godevenner.cinemabackend.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class TestDataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final ShowingRepository showingRepository;
    private final BookingRepository bookingRepository;
    private final SeatBookingRepository seatBookingRepository;

    private void createCostumers() {
        customerRepository.save(
                new Customer(
                        new User("jdoe", "password1"),
                        "John Doe",
                        "+1(555) 555-1111",
                        "johndoe@example.com",
                        LocalDate.now().minusYears(30)
                )
        );

        customerRepository.save(
                new Customer(
                        new User("asmith", "password2"),
                        "Alice Smith",
                        "+1(555) 555-2222",
                        "alicesmith@example.com",
                        LocalDate.now().minusYears(25)
                )
        );

        customerRepository.save(
                new Customer(
                        new User("bwayne", "batman123"),
                        "Bruce Wayne",
                        "+1(555) 555-3333",
                        "brucewayne@wayne.com",
                        LocalDate.now().minusYears(41)
                )
        );

        customerRepository.save(
                new Customer(
                        new User("ckent", "superman456"),
                        "Clark Kent",
                        "+1(555) 555-4444",
                        "clarkkent@dailyplanet.com",
                        LocalDate.now().minusYears(35)
                )
        );

        customerRepository.save(
                new Customer(
                        new User("dprince", "wonder789"),
                        "Diana Prince",
                        "+1(555) 555-5555",
                        "dianaprince@themyscira.com",
                        LocalDate.now().minusYears(28)
                )
        );
    }

    private void createShowings() {
        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(10, "a3"),
                                "Sal 1"
                        ),
                        new Movie("Alien", Genre.HORROR, 15, true, "imgur.com/alienposter"),
                        LocalDateTime.now().plusHours(14),
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(12, "b1"),
                                "Sal 2"
                        ),
                        new Movie("Inception", Genre.SCIFI, 13, true, "imgur.com/inceptionposter"),
                        LocalDateTime.now().plusHours(10),
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(10, "a3"),
                                "Sal 1"
                        ),
                        new Movie("Inception", Genre.SCIFI, 13, true, "imgur.com/inceptionposter"),
                        LocalDateTime.now().plusHours(4),
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(10, "a3"),
                                "Sal 1"
                        ),
                        new Movie("The Shining", Genre.HORROR, 16, false, "imgur.com/shiningposter"),
                        LocalDateTime.now().plusHours(12),
                        true
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(12, "b1"),
                                "Sal 2"
                        ),
                        new Movie("The Matrix", Genre.ACTION, 16, true, "imgur.com/matrixposter"),
                        LocalDateTime.now().plusHours(7),
                        true
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(10, "a3"),
                                "Sal 1"
                        ),
                        new Movie("Jurassic Park", Genre.ADVENTURE, 10, true, "imgur.com/jurassicposter"),
                        LocalDateTime.now().plusHours(8),
                        false)
        );
        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(14, "c1"),
                                "Sal 3"
                        ),
                        new Movie("The Lion King", Genre.ANIMATION, 7, true, "imgur.com/lionkingposter"),
                        LocalDateTime.now().plusHours(5),
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(16, "d1"),
                                "Sal 4"
                        ),
                        new Movie("Titanic", Genre.DRAMA, 12, true, "imgur.com/titanicposter"),
                        LocalDateTime.now().plusHours(3),
                        true
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(14, "c1"),
                                "Sal 3"
                        ),
                        new Movie("Toy Story", Genre.ANIMATION, 7, true, "imgur.com/toystoryposter"),
                        LocalDateTime.now().plusHours(9),
                        true
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(12, "b2"),
                                "Sal 2"
                        ),
                        new Movie("Fight Club", Genre.DRAMA, 18, false, "imgur.com/fightclubposter"),
                        LocalDateTime.now().plusHours(6),
                        true
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(20, "e1"),
                                "Sal 5"
                        ),
                        new Movie("Avengers: Endgame", Genre.ACTION, 12, true, "imgur.com/endgameposter"),
                        LocalDateTime.now().plusHours(11),
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(10, "a1"),
                                "Sal 1"
                        ),
                        new Movie("The Godfather", Genre.DRAMA, 18, true, "imgur.com/godfatherposter"),
                        LocalDateTime.now().plusHours(2),
                        true
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(18, "f1"),
                                "Sal 6"
                        ),
                        new Movie("Finding Nemo", Genre.ANIMATION, 5, true, "imgur.com/findingnemo"),
                        LocalDateTime.now().plusHours(4),
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(12, "b2"),
                                "Sal 2"
                        ),
                        new Movie("Pulp Fiction", Genre.ACTION, 18, true, "imgur.com/pulpfictionposter"),
                        LocalDateTime.now().plusHours(8),
                        true
                )
        );
        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(15, "g1"),
                                "Sal 7"
                        ),
                        new Movie("Jurassic World", Genre.ADVENTURE, 12, true, "imgur.com/jurassicworldposter"),
                        LocalDateTime.now().plusHours(3),
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(10, "h1"),
                                "Sal 8"
                        ),
                        new Movie("Get Out", Genre.HORROR, 15, true, "imgur.com/getoutposter"),
                        LocalDateTime.now().plusHours(4),
                        true
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(20, "i1"),
                                "Sal 9"
                        ),
                        new Movie("The Notebook", Genre.ROMANCE, 12, true, "imgur.com/thenotebookposter"),
                        LocalDateTime.now().plusHours(5),
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(18, "j1"),
                                "Sal 10"
                        ),
                        new Movie("Mad Max: Fury Road", Genre.ACTION, 16, true, "imgur.com/madmaxposter"),
                        LocalDateTime.now().plusHours(6),
                        true
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(12, "k1"),
                                "Sal 11"
                        ),
                        new Movie("Superbad", Genre.COMEDY, 13, true, "imgur.com/superbadposter"),
                        LocalDateTime.now().plusHours(2),
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(16, "l1"),
                                "Sal 12"
                        ),
                        new Movie("The Shawshank Redemption", Genre.DRAMA, 18, true, "imgur.com/shawshankposter"),
                        LocalDateTime.now().plusHours(7),
                        true
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(14, "m1"),
                                "Sal 13"
                        ),
                        new Movie("Gone Girl", Genre.THRILLER, 16, true, "imgur.com/gonegirlposter"),
                        LocalDateTime.now().plusHours(8),
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(10, "n1"),
                                "Sal 14"
                        ),
                        new Movie("Knives Out", Genre.MYSTERY, 13, true, "imgur.com/knivesoutposter"),
                        LocalDateTime.now().plusHours(9),
                        true
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(20, "o1"),
                                "Sal 15"
                        ),
                        new Movie("Shrek", Genre.ANIMATION, 5, true, "imgur.com/shrekposter"),
                        LocalDateTime.now().plusHours(10),
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(8, "p1"),
                                "Sal 16"
                        ),
                        new Movie("March of the Penguins", Genre.DOCUMENTARY, 0, true, "imgur.com/marchofthepenguins"),
                        LocalDateTime.now().plusHours(11),
                        true
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(12, "q1"),
                                "Sal 17"
                        ),
                        new Movie("The Lord of the Rings: The Fellowship of the Ring", Genre.FANTASY, 12, true, "imgur.com/lotrposter"),
                        LocalDateTime.now().plusHours(12),
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(18, "r1"),
                                "Sal 18"
                        ),
                        new Movie("Interstellar", Genre.SCIFI, 13, true, "imgur.com/interstellarposter"),
                        LocalDateTime.now().plusHours(13),
                        true
                )
        );


    }

    private void createBookings() {
        bookingRepository.save(
                new Booking(
                        customerRepository.findById(1L).get(),
                        showingRepository.findById(1L).get()
                )
        );
        bookingRepository.save(
                new Booking(
                        customerRepository.findById(2L).get(),
                        showingRepository.findById(2L).get()
                )
        );
    }

    private void createSeatBookings() {
        seatBookingRepository.save(
                new SeatBooking(
                        bookingRepository.findById(1).get(),
                        1,
                        1
                )
        );
        seatBookingRepository.save(
                new SeatBooking(
                        bookingRepository.findById(1).get(),
                        2,
                        1
                )
        );
        seatBookingRepository.save(
                new SeatBooking(
                        bookingRepository.findById(2).get(),
                        1,
                        1
                )
        );
    }


    @Override
    public void run(String... args) throws Exception {
        createCostumers();
        createShowings();
        createBookings();
        createSeatBookings();

    }
}
