package godevenner.cinemabackend.booking.service;

import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.model.SeatBooking;
import godevenner.cinemabackend.booking.repository.BookingRepository;
import godevenner.cinemabackend.booking.repository.SeatBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingApiServiceImplementation implements BookingApiService{

    private final BookingRepository bookingRepository;
    private final SeatBookingRepository seatBookingRepository;

    private void saveBookings(List<Booking> bookings){
        bookingRepository.saveAll(bookings);
    }

    private void saveSeatBookings(List<SeatBooking> seatBookings){
        seatBookingRepository.saveAll(seatBookings);
    }

    @Override
    public List<Booking> getBookings() {
        return null;
    }

    @Override
    public List<SeatBooking> getSeatBookings() {
        return null;
    }

    @Override
    public List<Booking> getAllBookingsByShowingId(long id){
        return bookingRepository.findAllByShowingId(id);
    }
}
