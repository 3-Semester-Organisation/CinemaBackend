package godevenner.cinemabackend.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import godevenner.cinemabackend.costumer.Costumer;
import godevenner.cinemabackend.showing.model.Showing;
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
    @JoinColumn(name = "customer_id")
    private Costumer costumer;

    @ManyToOne
    @JoinColumn(name = "showing_id")
    @JsonBackReference
    private Showing showing;

    public Booking(Costumer costumer, Showing showing) {
        this.costumer = costumer;
        this.showing = showing;
    }



    public boolean ageRequirementMet() {
        return costumer.isOldEnough(showing.getMovieAgeLimit());
    }

}
