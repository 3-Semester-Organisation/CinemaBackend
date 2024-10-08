package godevenner.cinemabackend.movie;

import com.fasterxml.jackson.annotation.JsonBackReference;
import godevenner.cinemabackend.enums.Genre;
import godevenner.cinemabackend.showing.model.Showing;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
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

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Genre> genreList;

    private int ageLimit;
    private boolean isActive;
    private String thumbnail;
    @Column(unique = true)
    private String imdbId;
    // cool variables from omdb that could be used later
    private String runtime;
    private String Rated;

    public Movie(String title, String description, List<Genre> genreList, int ageLimit, boolean isActive, String thumbnail, String runtime, String imdbId) {
        this.title = title;
        this.description = description;
        this.genreList = genreList;
        this.ageLimit = ageLimit;
        this.isActive = isActive;
        this.thumbnail = thumbnail;
        this.runtime = runtime;
        this.imdbId = imdbId;
    }

    public Movie(String title, String description, List<Genre> genreList, int ageLimit, String thumbnail, String runtime, String imdbId) {
        this.title = title;
        this.description = description;
        this.genreList = genreList;
        this.ageLimit = ageLimit;
        this.thumbnail = thumbnail;
        this.runtime = runtime;
        this.imdbId = imdbId;
    }

    //used for posting a showing.
    public Movie(long id) {
        this.id = id;
    }
}
