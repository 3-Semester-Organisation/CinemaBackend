package godevenner.cinemabackend.config;

import godevenner.cinemabackend.booking.repository.BookingRepository;
import godevenner.cinemabackend.costumer.Costumer;
import godevenner.cinemabackend.costumer.CustomerRepository;
import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.movie.MovieRepository;
import godevenner.cinemabackend.showing.Showing;
import godevenner.cinemabackend.showing.ShowingRepository;
import godevenner.cinemabackend.theatre.Theatre;
import godevenner.cinemabackend.theatre.TheatreRepository;
import godevenner.cinemabackend.theatrelayout.Layout;
import godevenner.cinemabackend.user.User;
import godevenner.cinemabackend.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Transactional
@Component
@RequiredArgsConstructor
public class TestDataLoader implements CommandLineRunner {

    private final BookingRepository bookingRepository;
    private final TheatreRepository theatreRepository;
    private final CustomerRepository customerRepository;
    private final MovieRepository movieRepository;
    private final ShowingRepository showingRepository;
    private final UserRepository userRepository;


    public void createCostumers() {


        customerRepository.save(
            new Costumer("John Reese", 40404040, "poi@show.dk", LocalDate.of(1994, 7, 7),
                    new User("johnlul","1234"))
        );

//        userRepository.save(new User(
//            new Costumer("Jane Doe", 50505050, "jane@show.dk", LocalDate.of(1992, 5, 15)),
//            null, "JaneUsername", "password123"
//        ));
//
//        userRepository.save(new User(
//            new Costumer("Mark Spencer", 60606060, "mark@show.dk", LocalDate.of(1988, 11, 23)),
//            null, "MarkUsername", "markPass"
//        ));
//
//        userRepository.save(new User(
//            new Costumer("Lucy Hale", 70707070, "lucy@show.dk", LocalDate.of(1990, 3, 30)),
//            null, "LucyUsername", "lucy123"
//        ));
//
//        userRepository.save(new User(
//            new Costumer("Michael Scott", 80808080, "michael@dundermifflin.com", LocalDate.of(1985, 9, 17)),
//            null, "MichaelUsername", "worldsbestboss"
//        ));;
    }


    public void createShowings() {
        showingRepository.save(new Showing(LocalDateTime.now().plusDays(3), false,
                new Movie("Terminator X", Genre.ACTION, 15, true, "imgur.com/poster"),
                new Theatre(new Layout(20,12),"Sal 1"))
        );
    }


    @Override
    public void run(String... args) throws Exception {
        createCostumers();
        createShowings();
    }
}
