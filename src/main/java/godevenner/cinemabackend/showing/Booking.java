package godevenner.cinemabackend.showing;

import godevenner.cinemabackend.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    @OneToOne
    @JoinColumn(name = "showing_id")
    private Showing showing;

    private int row;
    private String seat;
    private SeatType seatType;
}
