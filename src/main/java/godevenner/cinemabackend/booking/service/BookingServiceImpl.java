package godevenner.cinemabackend.booking.service;

import godevenner.cinemabackend.booking.dto.BookingCaS;
import godevenner.cinemabackend.booking.dto.BookingRequest;
import godevenner.cinemabackend.booking.dto.SeatRowData;
import godevenner.cinemabackend.booking.mapper.BookingCaSMapper;
//import godevenner.cinemabackend.booking.mapper.BookingRequestMapper;
import godevenner.cinemabackend.booking.model.Booking;
import godevenner.cinemabackend.booking.model.SeatBooking;
import godevenner.cinemabackend.booking.repository.BookingRepository;
import godevenner.cinemabackend.booking.repository.SeatBookingRepository;
import godevenner.cinemabackend.customer.Customer;
import godevenner.cinemabackend.customer.CustomerRepository;
import godevenner.cinemabackend.showing.ShowingRepository;
import godevenner.cinemabackend.showing.model.Showing;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final SeatBookingRepository seatBookingRepository;
//    private final BookingRequestMapper bookingRequestMapper;
    private final BookingCaSMapper bookingCaSMapper;
    private final ShowingRepository showingRepository;
    private final CustomerRepository costumerRepository;


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
    public List<BookingCaS> getAllBookingsByShowingId(long id){
        //return bookingRepository.findAllByShowingId(id);
        List<Booking> bookings = bookingRepository.findAllByShowingId(id);
        return bookings.stream()
                .map(bookingCaSMapper)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Booking> getBooking(long id){
        return bookingRepository.findById((int) id);
    }

    @Transactional
    public void saveBookingFromRequest(BookingRequest bookingRequest){
        Long showingId = bookingRequest.showingId();
        String email = bookingRequest.email();
        List<SeatRowData> seats = bookingRequest.bookedSeats();
        Customer costumer = null;
        Showing showing = null;
        Optional<Customer> customerOptional = costumerRepository.findByEmail(email);
        if(customerOptional.isPresent()){
            costumer = customerOptional.get();
        } else {
            Customer newCostumer = new Customer(email);
            costumerRepository.save(newCostumer);
            costumer = newCostumer;
        }
        Optional<Showing> showingOptional = showingRepository.findById(showingId);
        if (showingOptional.isPresent()){
            showing = showingOptional.get();
        } else {
            throw new RuntimeException("Showing not found");
        }
        Booking booking = new Booking(costumer, showing);
        bookingRepository.save(booking);
        for (SeatRowData seat : seats) {
            seatBookingRepository.save(new SeatBooking(booking,seat.seat(),seat.row()));
        }

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
    public List<SeatBooking> getAllSeatBookingsByShowingId(long id){
        return seatBookingRepository.findAllByBookingShowingId(id);
    }

    @Override
    public Optional<SeatBooking> getSeatBooking(long id){
        return seatBookingRepository.findById((int) id);
    }

//    @Override
//    public Booking createSeatBooking(BookingRequest requestedBooking){
//        Booking booking = bookingRequestMapper.apply(requestedBooking);
//        Booking savedBooking = bookingRepository.save(booking);
//
//        List<SeatBooking> bookedSeats = requestedBooking.bookedSeats();
//
//        for (SeatBooking seatBooking : bookedSeats) {
//            seatBooking.setBooking(savedBooking);
//        }
//        seatBookingRepository.saveAll(bookedSeats);
//
//        return savedBooking;
//    }

    @Override
    public ResponseEntity<SeatBooking> updateSeatBooking(long id, SeatBooking seatBooking){
        Optional<SeatBooking> alreadyExists = seatBookingRepository.findById((int) id);
        if(alreadyExists.isPresent()){
            seatBooking.setId(id);
            seatBookingRepository.save(seatBooking);
            return ResponseEntity.ok(seatBooking);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> deleteSeatBooking(long id){
        Optional<SeatBooking> alreadyExists = seatBookingRepository.findById((int) id);
        if(alreadyExists.isPresent()){
            seatBookingRepository.delete(alreadyExists.get());
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
