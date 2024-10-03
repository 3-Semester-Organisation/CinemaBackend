package godevenner.cinemabackend.theatre.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
        // en biograf har ikke én showing, det har enten many to one relation, eller bare ikke en relation
//    @OneToOne(mappedBy = "theatre")
//    private Showing showing;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private Set<TheatreSeat> theatreSeats = new HashSet<>();

    public void addSeat(TheatreSeat theatreSeat) {
        theatreSeat.setTheatre(this);
        theatreSeats.add(theatreSeat);
    }
    public void addSeat(List<TheatreSeat> theatreSeats) {
        for (TheatreSeat theatreSeat : theatreSeats) {
            theatreSeat.setTheatre(this);
            this.theatreSeats.add(theatreSeat);
        }
    }

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private Set<TheatreLayout> theatreLayouts = new HashSet<>();

    public void addTheatreLayout(TheatreLayout theatreLayout) {
        theatreLayout.setTheatre(this);
        theatreLayouts.add(theatreLayout);
    }
    public void addTheatreLayout(List<TheatreLayout> thatreLayouts) {
        for (TheatreLayout theatreLayout : thatreLayouts) {
            theatreLayout.setTheatre(this);
            this.theatreLayouts.add(theatreLayout);
        }
    }

    private String name;

    public Theatre(String name) {
        this.name = name;
    }
}
