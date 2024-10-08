package godevenner.cinemabackend.booking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Booking booking;

    private int seatNumber;
    private int seatRowNumber;

    public SeatBooking(Booking booking, int seatNumber, int seatRowNumber) {
        this.booking = booking;
        this.seatNumber = seatNumber;
        this.seatRowNumber = seatRowNumber;
    }

    public SeatBooking(int seatNumber, int seatRowNumber) {
        this.seatNumber = seatNumber;
        this.seatRowNumber = seatRowNumber;
    }

}
