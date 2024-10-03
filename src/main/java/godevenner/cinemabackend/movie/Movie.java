package godevenner.cinemabackend.movie;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Showing> showingSet;

    private String title;
    private String description;
    private Genre genre;
    private int ageLimit;
    private boolean isActive;
    private String thumbnail;

    public Movie(String title, String description, Genre genre, int ageLimit, boolean isActive, String thumbnail) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.ageLimit = ageLimit;
        this.isActive = isActive;
        this.thumbnail = thumbnail;
    }

    //used for posting a showing.
    public Movie(long id) {
        this.id = id;
    }
}
