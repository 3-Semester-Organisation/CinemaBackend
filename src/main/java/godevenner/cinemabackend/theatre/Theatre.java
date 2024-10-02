package godevenner.cinemabackend.theatre;

import godevenner.cinemabackend.theatrelayout.Layout;
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

//    @OneToOne(mappedBy = "theatre")
//    private Showing showing;

    @OneToOne(cascade = CascadeType.ALL)
    private Layout layout;

    private String name;

    public Theatre(Layout theatreLayout, String name) {
//        this.showing = showing;
        this.layout = layout;
        this.name = name;
    }
}
