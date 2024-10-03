package godevenner.cinemabackend.theatre.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TheatreLayout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    Theatre theatre;

    private int theatreRow;
    private int theatreCol;

    public TheatreLayout(int theatreRow, int theatreCol) {
        this.theatreRow = theatreRow;
        this.theatreCol = theatreCol;
    }
}
