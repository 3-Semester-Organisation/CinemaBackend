package godevenner.cinemabackend.booking.model;

import godevenner.cinemabackend.customer.Customer;
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
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "showing_id")
    private Showing showing;

    public Booking(Customer customer, Showing showing) {
        this.customer = customer;
        this.showing = showing;
    }
}