package godevenner.cinemabackend.showing;


import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.theatre.Theatre;
import godevenner.cinemabackend.theatrelayout.TheatreLayout;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ShowingRepositoryTest {

    @Autowired
    private ShowingRepository showingRepository;

    @Test
    void Showing_getAllByMovieId_MovieId_ReturnsShowingSet() {
        // arrange
        Set<Showing> expectedShowingSet = new HashSet<>();

        LocalDateTime specificDateTime = LocalDateTime.of(2023, Month.APRIL, 15, 10, 30, 0);
        Showing expectedShowing = new Showing(
                new Theatre(
                        new TheatreLayout(10, "a3"),
                        "Sal 1"
                ),
                new Movie("Alien", "After investigating a mysterious transmission of unknown origin, the crew of a commercial spacecraft encounters a deadly lifeform.", List.of(Genre.HORROR, Genre.THRILLER), 15, true, "https://m.media-amazon.com/images/M/MV5BOGQzZTBjMjQtOTVmMS00NGE5LWEyYmMtOGQ1ZGZjNmRkYjFhXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg"),
                specificDateTime,
                false
        );
        expectedShowingSet.add(expectedShowing);
        showingRepository.save(expectedShowing);

        long movieId = 1;

        // act
        List<Showing> showingList = showingRepository.findAll();
        Set<Showing> actualShowingSet = new HashSet<>();
        actualShowingSet.add(showingList.getFirst());

        // assert
        assertEquals(expectedShowingSet, actualShowingSet);
    }

    @Test
    void Showing_getAllByMovieId_MovieId_ReturnsEmptyShowingSet() {
        // arrange
        int expectedShowingSetSize;

        LocalDateTime specificDateTime = LocalDateTime.of(2023, Month.APRIL, 15, 10, 30, 0);
        Showing expectedShowing = new Showing(
                new Theatre(
                        new TheatreLayout(10, "a3"),
                        "Sal 1"
                ),
                new Movie("Alien", "After investigating a mysterious transmission of unknown origin, the crew of a commercial spacecraft encounters a deadly lifeform.", List.of(Genre.HORROR, Genre.THRILLER), 15, true, "https://m.media-amazon.com/images/M/MV5BOGQzZTBjMjQtOTVmMS00NGE5LWEyYmMtOGQ1ZGZjNmRkYjFhXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg"),
                specificDateTime,
                false
        );

        showingRepository.save(expectedShowing);

        long movieId = 9999; //nonexistent movieId

        // act
        Set<Showing> actualShowingSet = showingRepository.getAllByMovieId(movieId);
        expectedShowingSetSize = 0;

        // assert
        assertEquals(expectedShowingSetSize, actualShowingSet.size());
    }

    @Test
    void Showing_existsByTheatreAndStartTime_TheatreAndLocalDateTime_ReturnsTrue() {

        LocalDateTime specificDateTime = LocalDateTime.of(2023, Month.APRIL, 15, 10, 30, 0);
        Theatre theatre = new Theatre(
                new TheatreLayout(10, "a3"), "Sal 1");
        Showing expectedShowing = new Showing(
                theatre,
                new Movie("Alien", "After investigating a mysterious transmission of unknown origin, the crew of a commercial spacecraft encounters a deadly lifeform.", List.of(Genre.HORROR, Genre.THRILLER), 15, true, "https://m.media-amazon.com/images/M/MV5BOGQzZTBjMjQtOTVmMS00NGE5LWEyYmMtOGQ1ZGZjNmRkYjFhXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg"),
                specificDateTime,
                false
        );
        showingRepository.save(expectedShowing);

        boolean expectedResult = true;
        boolean actualResult = showingRepository.existsByTheatreAndStartTime(theatre, specificDateTime);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void Showing_existsByTheatreAndStartTime_TheatreAndLocalDateTime_ReturnsFalse() {

        LocalDateTime noneConflictingDate = LocalDateTime.now();
        LocalDateTime specificDateTime = LocalDateTime.of(2023, Month.APRIL, 15, 10, 30, 0);
        Theatre theatre = new Theatre(
                new TheatreLayout(10, "a3"), "Sal 1");
        Showing expectedShowing = new Showing(
                theatre,
                new Movie("Alien", "After investigating a mysterious transmission of unknown origin, the crew of a commercial spacecraft encounters a deadly lifeform.", List.of(Genre.HORROR, Genre.THRILLER), 15, true, "https://m.media-amazon.com/images/M/MV5BOGQzZTBjMjQtOTVmMS00NGE5LWEyYmMtOGQ1ZGZjNmRkYjFhXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg"),
                specificDateTime,
                false
        );
        showingRepository.save(expectedShowing);

        boolean expectedResult = false;
        boolean actualResult = showingRepository.existsByTheatreAndStartTime(theatre, noneConflictingDate);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void Showing_findLatestShowingByTheatreId_ShowingId_ReturnsShowingList() {
        List<Showing> expectedShowingList = new ArrayList<>();
        LocalDateTime specificDateTime = LocalDateTime.of(2023, Month.APRIL, 15, 10, 30, 0);
        Theatre theatre = new Theatre(
                new TheatreLayout(10, "a3"), "Sal 1");
        Showing expectedShowing = new Showing(
                theatre,
                new Movie("Alien", "After investigating a mysterious transmission of unknown origin, the crew of a commercial spacecraft encounters a deadly lifeform.", List.of(Genre.HORROR, Genre.THRILLER), 15, true, "https://m.media-amazon.com/images/M/MV5BOGQzZTBjMjQtOTVmMS00NGE5LWEyYmMtOGQ1ZGZjNmRkYjFhXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg"),
                specificDateTime,
                false
        );
        expectedShowingList.add(expectedShowing);
        showingRepository.save(expectedShowing);

        List<Showing> actualShowingList = showingRepository.findLatestShowingByTheatreId(theatre.getId());

        assertEquals(expectedShowingList, actualShowingList);
    }
}
