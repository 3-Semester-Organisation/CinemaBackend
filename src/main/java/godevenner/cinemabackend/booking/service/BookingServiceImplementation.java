package godevenner.cinemabackend.booking.service;

import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.model.SeatBooking;
import godevenner.cinemabackend.booking.repository.BookingRepository;
import godevenner.cinemabackend.booking.repository.SeatBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImplementation implements BookingService {

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
        List<Booking> bookings = bookingRepository.findAll();
        saveBookings(bookings);
        return bookings;
    }

    @Override
    public Optional<Booking> getBooking(long id){
        return bookingRepository.findById((int) id);
    }

    @Override
    public ResponseEntity<Booking> createBooking(Booking booking){
        Optional<Booking> alreadyExists = bookingRepository.findById((int)booking.getId());
        if(alreadyExists.isPresent()){
            return ResponseEntity.badRequest().body(alreadyExists.get());
        }else{
            bookingRepository.save(booking);
            return ResponseEntity.ok(booking);
        }
    }

    @Override
    public ResponseEntity<Booking> updateBooking(long id, Booking booking){
        Optional<Booking> alreadyExists = bookingRepository.findById((int) id);
        if(alreadyExists.isPresent()){
            booking.setId(id);
            bookingRepository.save(booking);
            return ResponseEntity.ok(booking);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteBooking(long id){
        Optional<Booking> alreadyExists = bookingRepository.findById((int) id);
        if(alreadyExists.isPresent()){
            bookingRepository.delete(alreadyExists.get());
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public List<Booking> getAllBookingsByShowingId(long id){
        return bookingRepository.findAllByShowingId(id);
    }

    @Override
    public List<SeatBooking> getSeatBookings() {
        List<SeatBooking> seatBookings = seatBookingRepository.findAll();
        saveSeatBookings(seatBookings);
        return seatBookings;
    }

    @Override
    public List<SeatBooking> getAllSeatBookingsByBookingId(long id){
        return seatBookingRepository.findAllByBookingId(id);
    }

    @Override
    public boolean existsById(long bookingId) {
        return bookingRepository.existsById((int) bookingId);
    }

    @Override
    public SeatBooking createSeatBooking(SeatBooking seatBooking) {
        return seatBookingRepository.save(seatBooking);
    }
}
