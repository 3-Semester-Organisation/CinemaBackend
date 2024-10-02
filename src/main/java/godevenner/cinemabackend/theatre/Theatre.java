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
        // en biograf har ikke én showing, det har enten many to one relation, eller bare ikke en relation
//    @OneToOne(mappedBy = "theatre")
//    private Showing showing;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "theatre_layout_id")
    private TheatreLayout theatreLayout;

    private String name;

    public Theatre(TheatreLayout theatreLayout, String name) {
        this.theatreLayout = theatreLayout;
        this.name = name;
    }
}
