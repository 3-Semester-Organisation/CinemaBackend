package godevenner.cinemabackend.theatrelayout;

import godevenner.cinemabackend.enums.SeatType;
import godevenner.cinemabackend.theatre.Theatre;
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

    @OneToOne(mappedBy = "theatreLayout")
    private Theatre theatre;

    private int seatRowNumber;
    private String seatNumber;
    private SeatType seatType;
}
