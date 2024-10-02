package godevenner.cinemabackend.theatrelayout;

import godevenner.cinemabackend.theatre.Theatre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Layout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToOne(mappedBy = "theatreLayout")
//    private Theatre theatre;

    private int theatreRows;
    private int theatreSeats;
//    private SeatType type;


    public Layout(int theatreRows, int theatreSeats) {
        this.theatreRows = theatreRows;
        this.theatreSeats = theatreSeats;
    }
}
