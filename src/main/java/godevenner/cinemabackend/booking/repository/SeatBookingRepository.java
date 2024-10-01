package godevenner.cinemabackend.booking.repository;

import godevenner.cinemabackend.booking.model.SeatBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatBookingRepository extends JpaRepository<SeatBooking, Integer> {
}
