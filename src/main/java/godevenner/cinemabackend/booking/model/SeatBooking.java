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
public class SeatBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    private int seatNumber;
    private int seatRowNumber;
}
