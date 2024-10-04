package godevenner.cinemabackend.theatre.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import godevenner.cinemabackend.theatre.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class TheatreSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonBackReference
    private Theatre theatre;

    private int theatreSeatNumber;
    private int theatreRowNumber;
    private SeatType seatType;

    public TheatreSeat(int theatreSeatNumber, int theatreRowNumber, SeatType seatType) {
        this.theatreSeatNumber = theatreSeatNumber;
        this.theatreRowNumber = theatreRowNumber;
        this.seatType = seatType;
    }
}
