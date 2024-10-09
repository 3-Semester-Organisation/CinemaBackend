package godevenner.cinemabackend.config;

import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.model.SeatBooking;
import godevenner.cinemabackend.booking.repository.BookingRepository;
import godevenner.cinemabackend.booking.repository.SeatBookingRepository;
import godevenner.cinemabackend.customer.Customer;
import godevenner.cinemabackend.customer.CustomerRepository;
import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.theatre.SeatType;
import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.showing.model.Showing;
import godevenner.cinemabackend.showing.ShowingRepository;
import godevenner.cinemabackend.theatre.TheatreRepository;
import godevenner.cinemabackend.theatre.model.Theatre;
import godevenner.cinemabackend.theatre.model.TheatreLayout;
import godevenner.cinemabackend.theatre.model.TheatreSeat;
import godevenner.cinemabackend.user.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Component
public class TestDataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final ShowingRepository showingRepository;
    private final BookingRepository bookingRepository;
    private final SeatBookingRepository seatBookingRepository;
    private final TheatreRepository theatreRepository;


    private List<TheatreSeat> createSeatsByRowsAndSeasts(int rows, int seats) {
        List<TheatreSeat> theatreSeats = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= seats; j++) {
                if(i == 1 && (j == 1 || j == seats)) {
                    theatreSeats.add(new TheatreSeat(j,i,SeatType.WHEELCHAIR));
                } else {
                    theatreSeats.add(new TheatreSeat(j,i,SeatType.STANDARD));
                }
            }
        }
        return theatreSeats;
    }

    private void CreateTheatres() {
        theatreRepository.save(new Theatre("Sal 1"));
        theatreRepository.save(new Theatre("Sal 2"));
    }

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
        Optional<Theatre> theatreOneOptional = theatreRepository.findById(1L);
        Optional<Theatre> theatreTwoOptional = theatreRepository.findById(2L);
        Theatre theatreOne = theatreOneOptional.get();
        Theatre theatreTwo = theatreTwoOptional.get();


        LocalDateTime specificDateTime = LocalDateTime.of(2023, Month.APRIL, 15, 10, 30, 0);
        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Alien", "After investigating a mysterious transmission of unknown origin, the crew of a commercial spacecraft encounters a deadly lifeform.", List.of(Genre.HORROR, Genre.THRILLER), 15, true, "https://m.media-amazon.com/images/M/MV5BOGQzZTBjMjQtOTVmMS00NGE5LWEyYmMtOGQ1ZGZjNmRkYjFhXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg", "117 min"),
                        LocalDateTime.now().plusHours(10),
                        false
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.", List.of(Genre.SCIFI, Genre.THRILLER), 13, true, "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "148 min"),
                        LocalDateTime.now().plusHours(10),
                        false
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Inception", "inception, inception,inception,inception,inception,inception,", List.of(Genre.SCIFI), 13, true, "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "148 min"),
                        LocalDateTime.now().plusHours(4),
                        false
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("The Shining", "A family heads to an isolated hotel for the winter, where a sinister presence influences the father into violence. At the same time, his psychic son sees horrifying forebodings from both the past and the future.", List.of(Genre.HORROR, Genre.THRILLER), 16, false, "https://m.media-amazon.com/images/M/MV5BZWFlYmY2MGEtZjVkYS00YzU4LTg0YjQtYzY1ZGE3NTA5NGQxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "146 min"),
                        LocalDateTime.now().plusHours(12),
                        true
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("The Matrix", "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.", List.of(Genre.ACTION), 16, true, "https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg", "136 min"),
                        LocalDateTime.now().plusHours(7),
                        true
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Jurassic Park", "An industrialist invites some experts to visit his theme park of cloned dinosaurs. After a power failure, the creatures run loose, putting everyone's lives, including his grandchildren's, in danger.", List.of(Genre.ADVENTURE), 10, true, "https://m.media-amazon.com/images/M/MV5BMjM2MDgxMDg0Nl5BMl5BanBnXkFtZTgwNTM2OTM5NDE@._V1_SX300.jpg", "90 min"),
                        LocalDateTime.now().plusHours(8),
                        false)
        );
        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("The Lion King", "Lion prince Simba and his father are targeted by his bitter uncle, who wants to ascend the throne himself.",List.of(Genre.ANIMATION), 7, true, "https://m.media-amazon.com/images/M/MV5BZGRiZDZhZjItM2M3ZC00Y2IyLTk3Y2MtMWY5YjliNDFkZTJlXkEyXkFqcGc@._V1_SX300.jpg", "120 min"),
                        LocalDateTime.now().plusHours(5),
                        false
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Titanic", "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.", List.of(Genre.DRAMA),12, true, "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg", "420 min"),
                        LocalDateTime.now().plusHours(3),
                        true
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Toy Story", "A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy's bedroom.", List.of(Genre.ANIMATION), 7, true, "https://m.media-amazon.com/images/M/MV5BMDU2ZWJlMjktMTRhMy00ZTA5LWEzNDgtYmNmZTEwZTViZWJkXkEyXkFqcGdeQXVyNDQ2OTk4MzI@._V1_SX300.jpg", "125 min"),
                        LocalDateTime.now().plusHours(9),
                        true
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Fight Club", "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.", List.of(Genre.DRAMA), 18, false, "https://m.media-amazon.com/images/M/MV5BOTgyOGQ1NDItNGU3Ny00MjU3LTg2YWEtNmEyYjBiMjI1Y2M5XkEyXkFqcGc@._V1_SX300.jpg", "190 min"),
                        LocalDateTime.now().plusHours(6),
                        true
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Avengers: Endgame", "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.",List.of(Genre.ACTION), 12, true, "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg", "80 min"),
                        LocalDateTime.now().plusHours(11),
                        false
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("The Godfather", "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.", List.of(Genre.DRAMA), 18, true, "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg", "79 min"),
                        LocalDateTime.now().plusHours(2),
                        true
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Finding Nemo", "After his son is captured in the Great Barrier Reef and taken to Sydney, a timid clownfish sets out on a journey to bring him home.", List.of(Genre.ANIMATION), 5, true, "https://m.media-amazon.com/images/M/MV5BMTc5NjExNTA5OV5BMl5BanBnXkFtZTYwMTQ0ODY2._V1_SX300.jpg", "110 min"),
                        LocalDateTime.now().plusHours(4),
                        false
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Pulp Fiction", "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.", List.of(Genre.ACTION), 18, true, "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg", "111 min"),
                        LocalDateTime.now().plusHours(8),
                        true
                )
        );
        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Jurassic World", "A new theme park, built on the original site of Jurassic Park, creates a genetically modified hybrid dinosaur, the Indominus Rex, which escapes containment and goes on a killing spree.", List.of(Genre.ADVENTURE), 12, true, "https://m.media-amazon.com/images/M/MV5BNzBhNzlkM2UtZTQyOC00NjUyLTkzMmMtNDQ1YTM5N2NmMGE5XkEyXkFqcGc@._V1_SX300.jpg", "123 min"),
                        LocalDateTime.now().plusHours(3),
                        false
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Get Out", "A young African-American visits his white girlfriend's parents for the weekend, where his simmering uneasiness about their reception of him eventually reaches a boiling point.",List.of(Genre.HORROR), 15, true, "https://m.media-amazon.com/images/M/MV5BMjUxMDQwNjcyNl5BMl5BanBnXkFtZTgwNzcwMzc0MTI@._V1_SX300.jpg", "142 min"),
                        LocalDateTime.now().plusHours(4),
                        true
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("The Notebook", "An elderly man reads to a woman with dementia the story of two young lovers whose romance is threatened by the difference in their respective social classes.",List.of(Genre.ROMANCE), 12, true, "https://m.media-amazon.com/images/M/MV5BNzc3Mzg1OGYtZjc3My00Y2NhLTgyOWUtYjRhMmI4OTkwNDg4XkEyXkFqcGdeQXVyMTU3NDU4MDg2._V1_SX300.jpg", "132 min"),
                        LocalDateTime.now().plusHours(5),
                        false
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Mad Max: Fury Road", "In a post-apocalyptic wasteland, a woman rebels against a tyrannical ruler in search for her homeland with the aid of a group of female prisoners, a psychotic worshipper and a drifter named Max.", List.of(Genre.ACTION), 16, true, "https://m.media-amazon.com/images/M/MV5BZDRkODJhOTgtOTc1OC00NTgzLTk4NjItNDgxZDY4YjlmNDY2XkEyXkFqcGc@._V1_SX300.jpg", "100 min"),
                        LocalDateTime.now().plusHours(6),
                        true
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Superbad", "Two co-dependent high school seniors are forced to deal with separation anxiety after their plan to stage a booze-soaked party goes awry.", List.of(Genre.COMEDY), 13, true, "https://m.media-amazon.com/images/M/MV5BY2VkMDg4ZTYtN2M3Yy00NWZiLWE2ODEtZjU5MjZkYWNkNGIzXkEyXkFqcGdeQXVyODY5Njk4Njc@._V1_SX300.jpg", "106 min"),
                        LocalDateTime.now().plusHours(2),
                        false
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("The Shawshank Redemption", "so many", List.of(Genre.DRAMA), 18, true, "https://m.media-amazon.com/images/M/MV5BMDAyY2FhYjctNDc5OS00MDNlLThiMGUtY2UxYWVkNGY2ZjljXkEyXkFqcGc@._V1_SX300.jpg", "999min"),
                        LocalDateTime.now().plusHours(7),
                        true
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Gone Girl", "gone yes", List.of(Genre.THRILLER), 16, true, "https://m.media-amazon.com/images/M/MV5BMTk0MDQ3MzAzOV5BMl5BanBnXkFtZTgwNzU1NzE3MjE@._V1_SX300.jpg", "231 min"),
                        LocalDateTime.now().plusHours(8),
                        false
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Knives Out", "nah brotha",List.of(Genre.MYSTERY), 13, true, "https://m.media-amazon.com/images/M/MV5BZDU5ZTRkYmItZjg0Mi00ZTQwLThjMWItNWM3MTMxMzVjZmVjXkEyXkFqcGc@._V1_SX300.jpg", "123 min"),
                        LocalDateTime.now().plusHours(9),
                        true
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Shrek", "sexy" ,List.of(Genre.ANIMATION), 5, true, "https://m.media-amazon.com/images/M/MV5BN2FkMTRkNTUtYTI0NC00ZjI4LWI5MzUtMDFmOGY0NmU2OGY1XkEyXkFqcGc@._V1_SX300.jpg", "90 min"),
                        LocalDateTime.now().plusHours(10),
                        false
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("March of the Penguins", "soliders ", List.of(Genre.DOCUMENTARY), 0, true, "https://m.media-amazon.com/images/M/MV5BMTM1NDc5MDYxMl5BMl5BanBnXkFtZTcwMjMzNDAzMQ@@._V1_SX300.jpg", "25 min"),
                        LocalDateTime.now().plusHours(11),
                        true
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("The Lord of the Rings: The Fellowship of the Ring", "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",List.of(Genre.FANTASY), 12, true, "https://m.media-amazon.com/images/M/MV5BNzIxMDQ2YTctNDY4MC00ZTRhLTk4ODQtMTVlOWY4NTdiYmMwXkEyXkFqcGc@._V1_SX300.jpg", "15 min"),
                        LocalDateTime.now().plusHours(12),
                        false
                )
        );

        showingRepository.save(
                new Showing(theatreOne,
                        new Movie("Interstellar", "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.", List.of(Genre.SCIFI), 13, true, "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg", "55 min"),
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
    @Transactional
    public void createTheatreLayout() {
        Optional<Theatre> theatreOptional = theatreRepository.findById(1L);
        if (theatreOptional.isPresent()) {
            Theatre theatre = theatreOptional.get();
            theatre.addSeat(List.of(
                    new TheatreSeat(
                            1,1, SeatType.STANDARD),
                    new TheatreSeat(
                            1,2, SeatType.STANDARD),
                    new TheatreSeat(
                            1,3, SeatType.STANDARD),
                    new TheatreSeat(
                            1,4, SeatType.STANDARD
                    )
            ));
            theatre.addTheatreLayout(List.of(
                    new TheatreLayout(0,3),
                    new TheatreLayout(0,7),
                    new TheatreLayout(5,0)
            ));
            theatre.addSeat(createSeatsByRowsAndSeasts(10,10));
        }

    }

    @Override
    public void run(String... args) throws Exception {
        createCostumers();
        CreateTheatres();
        createShowings();
        createBookings();
        createSeatBookings();
        createTheatreLayout();

    }



}
