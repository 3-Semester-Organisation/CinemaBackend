package godevenner.cinemabackend.showing;


import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.showing.model.Showing;
import godevenner.cinemabackend.theatre.model.Theatre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
@SpringBootTest
class ShowingRepositoryTest {
    @Autowired
    private ShowingRepository showingRepository;


    private Theatre theatre1;
    private Theatre theatre2;
    private Theatre theatre3;

    private Showing showing1;
    private Showing showing2;
    private Showing showing3;
    private Showing showing4;

    private LocalDateTime showingTime1;
    private LocalDateTime showingTime2;
    private LocalDateTime showingTime3;
    private LocalDateTime showingTime4;

    @BeforeEach
    void setUp() {
        setUpShowings();
    }


    @Test
    void Showing_getAllByMovieId_MovieId_ReturnsShowingSet() {
        // arrange
        Set<Showing> expectedShowingSet = new HashSet<>();
        expectedShowingSet.add(showing2);

        long movieId = 2;

        // act
        Set<Showing> actualShowingSet = showingRepository.getAllByMovieId(movieId);

        // assert
        assertEquals(expectedShowingSet, actualShowingSet);
    }

    @Test
    void Showing_getAllByMovieId_MovieId_ReturnsEmptyShowingSet() {
        // arrange
        int expectedShowingSetSize = 0;

        long movieId = 9999; //nonexistent movieId

        // act
        Set<Showing> actualShowingSet = showingRepository.getAllByMovieId(movieId);


        // assert
        assertEquals(expectedShowingSetSize, actualShowingSet.size());
    }

    @Test
    void Showing_existsByTheatreAndStartTime_TheatreAndLocalDateTime_ReturnsTrue() {

        boolean expectedResult = true;
        boolean actualResult = showingRepository.existsByTheatreAndStartTime(theatre1, showingTime1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void Showing_existsByTheatreAndStartTime_TheatreAndLocalDateTime_ReturnsFalse() {

        boolean expectedResult = false;
        boolean actualResult = showingRepository.existsByTheatreAndStartTime(theatre1, showingTime2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void Showing_findLatestShowingByTheatreId_ShowingId_ReturnsShowingList() {

        List<Showing> expectedShowingList = List.of(showing4);//This showing is in theatre3

        List<Showing> actualShowingList = showingRepository.findLatestShowingByTheatreId(theatre3.getId());

        System.out.println("exp:"+ expectedShowingList.getFirst().getId());
        System.out.println("act:"+ actualShowingList.getFirst().getId());
        assertEquals(expectedShowingList.getFirst(), actualShowingList.getFirst());
    }


    private void setUpShowings() {
        theatre1 = new Theatre("Sal 1");
        theatre2 = new Theatre("Sal 2");
        theatre3 = new Theatre("Sal 3");

        showingTime1 = LocalDateTime.of(2021, 1, 1, 1, 1);
        showingTime2 = LocalDateTime.of(2022, 2, 2, 2, 2);
        showingTime3 = LocalDateTime.of(2023, 3, 3, 3, 3);
        showingTime4 = LocalDateTime.of(2024, 4, 4, 4, 4);

        showing1 = new Showing(
                theatre1,
                new Movie("Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster.", List.of(Genre.SCIFI, Genre.THRILLER), 13, true, "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_SX300.jpg", "148 min", "tt1375666"),
                showingTime1,
                false
        );
        showing2 = new Showing(
                theatre2,
                new Movie("The Shining", "A family heads to an isolated hotel for the winter, where a sinister presence influences the father into violence. At the same time, his psychic son sees horrifying forebodings from both the past and the future.", List.of(Genre.HORROR, Genre.THRILLER), 16, false, "https://m.media-amazon.com/images/M/MV5BZWFlYmY2MGEtZjVkYS00YzU4LTg0YjQtYzY1ZGE3NTA5NGQxXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg", "146 min", "tt0081505"),
                showingTime2,
                true
        );
        showing3 = new Showing(
                theatre3,
                new Movie("Titanic", "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.", List.of(Genre.DRAMA), 12, true, "https://m.media-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg", "420 min", "tt0120338"),
                showingTime3,
                true
        );
        showing4 = new Showing(
                theatre3,
                new Movie("Interstellar", "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.", List.of(Genre.SCIFI), 13, true, "https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg", "55 min","tt0816692"),
                showingTime4,
                true
        );
        showingRepository.save(showing1);
        showingRepository.save(showing2);
        showingRepository.save(showing3);
        showingRepository.save(showing4);
    }
}