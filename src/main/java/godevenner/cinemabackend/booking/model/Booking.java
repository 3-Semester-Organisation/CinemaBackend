package godevenner.cinemabackend.booking.model;

import godevenner.cinemabackend.costumer.Costumer;
import godevenner.cinemabackend.enums.SeatType;
import godevenner.cinemabackend.showing.Showing;
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

    @ManyToOne
    @JoinColumn(name = "showing_id")
    private Showing showing;



    public boolean ageRequirementMet() {
        return costumer.isOldEnough(showing.getMovieAgeLimit());
    }

}
