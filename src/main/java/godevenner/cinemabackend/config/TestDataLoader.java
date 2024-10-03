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
import java.time.Month;

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
        LocalDateTime specificDateTime = LocalDateTime.of(2023, Month.APRIL, 15, 10, 30, 0);
        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(10, "a3"),
                                "Sal 1"
                        ),
                        new Movie("Alien", "scary aliens", Genre.HORROR, 15, true, "https://m.media-amazon.com/images/M/MV5BOGQzZTBjMjQtOTVmMS00NGE5LWEyYmMtOGQ1ZGZjNmRkYjFhXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg"),
                        specificDateTime,
                        false
                )
        );

        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(12, "b1"),
                                "Sal 2"
                        ),
                        new Movie("Inception", "brain tiring", Genre.SCIFI, 13, true, "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg"),
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
                        new Movie("Inception", "inception, inception,inception,inception,inception,inception,", Genre.SCIFI, 13, true, "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg"),
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
                        new Movie("The Shining", "scary shit man", Genre.HORROR, 16, false, "https://m.media-amazon.com/images/M/MV5BZWFlYmY2MGEtZjVkYS00YzU4LTg0YjQtYzY1ZGE3NTA5NGQxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg"),
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
                        new Movie("The Matrix", "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.", Genre.ACTION, 16, true, "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg"),
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
                        new Movie("Jurassic Park", "for dino lovers", Genre.ADVENTURE, 10, true, "https://m.media-amazon.com/images/M/MV5BMjM2MDgxMDg0Nl5BMl5BanBnXkFtZTgwNTM2OTM5NDE@._V1_SX300.jpg"),
                        LocalDateTime.now().plusHours(8),
                        false)
        );
        showingRepository.save(
                new Showing(
                        new Theatre(
                                new TheatreLayout(14, "c1"),
                                "Sal 3"
                        ),
                        new Movie("The Lion King", "the lions can speak :O",Genre.ANIMATION, 7, true, "https://m.media-amazon.com/images/M/MV5BZGRiZDZhZjItM2M3ZC00Y2IyLTk3Y2MtMWY5YjliNDFkZTJlXkEyXkFqcGc@._V1_SX300.jpg"),
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
                        new Movie("Titanic", "some say this movie is funny", Genre.DRAMA, 12, true, "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg"),
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
                        new Movie("Toy Story", "a true nightmare", Genre.ANIMATION, 7, true, "https://m.media-amazon.com/images/M/MV5BMDU2ZWJlMjktMTRhMy00ZTA5LWEzNDgtYmNmZTEwZTViZWJkXkEyXkFqcGdeQXVyNDQ2OTk4MzI@._V1_SX300.jpg"),
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
                        new Movie("Fight Club", "fighting yes", Genre.DRAMA, 18, false, "https://m.media-amazon.com/images/M/MV5BOTgyOGQ1NDItNGU3Ny00MjU3LTg2YWEtNmEyYjBiMjI1Y2M5XkEyXkFqcGc@._V1_SX300.jpg"),
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
                        new Movie("Avengers: Endgame", "best movie",Genre.ACTION, 12, true, "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg"),
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
                        new Movie("The Godfather", "farther here", Genre.DRAMA, 18, true, "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg"),
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
                        new Movie("Finding Nemo", "sushi", Genre.ANIMATION, 5, true, "https://m.media-amazon.com/images/M/MV5BMTc5NjExNTA5OV5BMl5BanBnXkFtZTYwMTQ0ODY2._V1_SX300.jpg"),
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
                        new Movie("Pulp Fiction", "have not seen. WTF Chris", Genre.ACTION, 18, true, "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg"),
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
                        new Movie("Jurassic World", "roar", Genre.ADVENTURE, 12, true, "https://m.media-amazon.com/images/M/MV5BNzBhNzlkM2UtZTQyOC00NjUyLTkzMmMtNDQ1YTM5N2NmMGE5XkEyXkFqcGc@._V1_SX300.jpg"),
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
                        new Movie("Get Out", "nahh bud",Genre.HORROR, 15, true, "https://m.media-amazon.com/images/M/MV5BMjUxMDQwNjcyNl5BMl5BanBnXkFtZTgwNzcwMzc0MTI@._V1_SX300.jpg"),
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
                        new Movie("The Notebook", "romance yes",Genre.ROMANCE, 12, true, "https://m.media-amazon.com/images/M/MV5BNzc3Mzg1OGYtZjc3My00Y2NhLTgyOWUtYjRhMmI4OTkwNDg4XkEyXkFqcGdeQXVyMTU3NDU4MDg2._V1_SX300.jpg"),
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
                        new Movie("Mad Max: Fury Road", "chiiiill", Genre.ACTION, 16, true, "https://m.media-amazon.com/images/M/MV5BZDRkODJhOTgtOTc1OC00NTgzLTk4NjItNDgxZDY4YjlmNDY2XkEyXkFqcGc@._V1_SX300.jpg"),
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
                        new Movie("Superbad", "very", Genre.COMEDY, 13, true, "https://m.media-amazon.com/images/M/MV5BY2VkMDg4ZTYtN2M3Yy00NWZiLWE2ODEtZjU5MjZkYWNkNGIzXkEyXkFqcGdeQXVyODY5Njk4Njc@._V1_SX300.jpg"),
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
                        new Movie("The Shawshank Redemption", "so many", Genre.DRAMA, 18, true, "https://m.media-amazon.com/images/M/MV5BMDAyY2FhYjctNDc5OS00MDNlLThiMGUtY2UxYWVkNGY2ZjljXkEyXkFqcGc@._V1_SX300.jpg"),
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
                        new Movie("Gone Girl", "gone yes", Genre.THRILLER, 16, true, "https://m.media-amazon.com/images/M/MV5BMTk0MDQ3MzAzOV5BMl5BanBnXkFtZTgwNzU1NzE3MjE@._V1_SX300.jpg"),
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
                        new Movie("Knives Out", "nah brotha",Genre.MYSTERY, 13, true, "https://m.media-amazon.com/images/M/MV5BZDU5ZTRkYmItZjg0Mi00ZTQwLThjMWItNWM3MTMxMzVjZmVjXkEyXkFqcGc@._V1_SX300.jpg"),
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
                        new Movie("Shrek", "sexy" ,Genre.ANIMATION, 5, true, "https://m.media-amazon.com/images/M/MV5BN2FkMTRkNTUtYTI0NC00ZjI4LWI5MzUtMDFmOGY0NmU2OGY1XkEyXkFqcGc@._V1_SX300.jpg"),
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
                        new Movie("March of the Penguins", "soliders ", Genre.DOCUMENTARY, 0, true, "https://m.media-amazon.com/images/M/MV5BMTM1NDc5MDYxMl5BMl5BanBnXkFtZTcwMjMzNDAzMQ@@._V1_SX300.jpg"),
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
                        new Movie("The Lord of the Rings: The Fellowship of the Ring", "damn a long name",Genre.FANTASY, 12, true, "https://m.media-amazon.com/images/M/MV5BNzIxMDQ2YTctNDY4MC00ZTRhLTk4ODQtMTVlOWY4NTdiYmMwXkEyXkFqcGc@._V1_SX300.jpg"),
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
                        new Movie("Interstellar", "love this moive", Genre.SCIFI, 13, true, "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg"),
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
