package godevenner.cinemabackend.booking.repository;

import godevenner.cinemabackend.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
