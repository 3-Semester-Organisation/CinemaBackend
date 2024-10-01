package godevenner.cinemabackend.movie;

import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.showing.Showing;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "movie")
    private Set<Showing> showingSet;

    private String title;
    private Genre genre;
    private int ageLimit;
    private boolean isActive;
    private String thumbnail;

    public Movie(Set<Showing> showingSet, String title, Genre genre, int ageLimit, boolean isActive, String thumbnail) {
        this.showingSet = showingSet;
        this.title = title;
        this.genre = genre;
        this.ageLimit = ageLimit;
        this.isActive = isActive;
        this.thumbnail = thumbnail;
    }
}
