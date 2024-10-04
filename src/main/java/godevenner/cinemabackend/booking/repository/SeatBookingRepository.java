package godevenner.cinemabackend.booking.repository;

import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.model.SeatBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatBookingRepository extends JpaRepository<SeatBooking, Integer> {
    List<SeatBooking> findAllByBookingId(Long id);
    List<SeatBooking> findAllbyBookingShowingId(Long id);
}
