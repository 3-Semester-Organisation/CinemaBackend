package godevenner.cinemabackend.theatre;

import godevenner.cinemabackend.enums.SeatType;
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

    private int row;
    private String seat;
    private SeatType type;
}
