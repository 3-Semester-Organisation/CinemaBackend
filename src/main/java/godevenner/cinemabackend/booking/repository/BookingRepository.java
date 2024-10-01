package godevenner.cinemabackend.booking.repository;

import godevenner.cinemabackend.booking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findAllByShowingId(Long id);
}
