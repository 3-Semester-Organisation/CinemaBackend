package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.booking.Booking;
import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.theatre.Theatre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Showing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;

    @OneToOne(mappedBy = "showing")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private LocalDateTime startTime; //LocalDateTime.of(1997,5,13,20,45);
    private boolean isCancelled;
}
