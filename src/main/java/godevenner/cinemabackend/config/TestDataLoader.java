package godevenner.cinemabackend.config;

import godevenner.cinemabackend.costumer.Costumer;
import godevenner.cinemabackend.costumer.CostumerRepository;
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

    private final CostumerRepository costumerRepository;
    private final ShowingRepository showingRepository;

    private void createCostumers() {
        costumerRepository.save(
                new Costumer(
                        new User("jdoe", "password1"),
                        "John Doe",
                        "+1(555) 555-1111",
                        "johndoe@example.com",
                        LocalDate.now().minusYears(30)
                )
        );

        costumerRepository.save(
                new Costumer(
                        new User("asmith", "password2"),
                        "Alice Smith",
                        "+1(555) 555-2222",
                        "alicesmith@example.com",
                        LocalDate.now().minusYears(25)
                )
        );

        costumerRepository.save(
                new Costumer(
                        new User("bwayne", "batman123"),
                        "Bruce Wayne",
                        "+1(555) 555-3333",
                        "brucewayne@wayne.com",
                        LocalDate.now().minusYears(41)
                )
        );

        costumerRepository.save(
                new Costumer(
                        new User("ckent", "superman456"),
                        "Clark Kent",
                        "+1(555) 555-4444",
                        "clarkkent@dailyplanet.com",
                        LocalDate.now().minusYears(35)
                )
        );

        costumerRepository.save(
                new Costumer(
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

    }


    @Override
    public void run(String... args) throws Exception {
        createCostumers();
        createShowings();

    }
}
