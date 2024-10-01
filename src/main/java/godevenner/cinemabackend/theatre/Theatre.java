package godevenner.cinemabackend.theatre;

import godevenner.cinemabackend.showing.Showing;
import godevenner.cinemabackend.theatrelayout.TheatreLayout;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "theatre")
    private Showing showing;

    @OneToOne
    @JoinColumn(name = "theatre_layout_id")
    private TheatreLayout theatreLayout;

    private String name;

    public Theatre(Showing showing, TheatreLayout theatreLayout, String name) {
        this.showing = showing;
        this.theatreLayout = theatreLayout;
        this.name = name;
    }
}
