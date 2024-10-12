package godevenner.cinemabackend.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import godevenner.cinemabackend.customer.Customer;
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
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "showing_id")
    @JsonBackReference
    private Showing showing;

    public Booking(Customer customer, Showing showing) {
        this.customer = customer;
        this.showing = showing;
    }



    public boolean ageRequirementMet() {
        return customer.isOldEnough(showing.getMovieAgeLimit());
    }

}
