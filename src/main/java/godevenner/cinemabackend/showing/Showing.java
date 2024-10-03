package godevenner.cinemabackend.showing;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.movie.Movie;
import godevenner.cinemabackend.theatre.Theatre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Showing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_id")
    @JsonManagedReference
    private Theatre theatre;

    @OneToMany(mappedBy = "showing", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Booking> booking;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    @JsonManagedReference
    private Movie movie;
    private LocalDateTime startTime; //LocalDateTime.of(1997,5,13,20,45);
    private boolean isCancelled;

    public Showing(Theatre theatre, Movie movie, LocalDateTime startTime, boolean isCancelled) {
        this.theatre = theatre;
        this.movie = movie;
        this.startTime = startTime;
        this.isCancelled = isCancelled;
    }

    //used when posting a new showing to db
    public Showing(Theatre theatre, Movie movie, LocalDateTime startTime) {
        this.theatre = theatre;
        this.movie = movie;
        this.startTime = startTime;
        this.isCancelled = false;
    }

    public int getMovieAgeLimit() {
        return movie.getAgeLimit();
    }
}
