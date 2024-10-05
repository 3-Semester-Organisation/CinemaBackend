package godevenner.cinemabackend.showing.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import godevenner.cinemabackend.booking.model.SeatBooking;
import godevenner.cinemabackend.theatre.model.TheatreLayout;
import godevenner.cinemabackend.theatre.model.TheatreSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class SeatMap {
    private List<List<String>> seatMap;
    private List<SeatBooking> seatBookings;
    @JsonIgnore
    private Set<TheatreSeat> theatreSeats;

    public SeatMap(List<SeatBooking> seatBookings, Set<TheatreSeat> theatreSeats) {
        seatMap = new ArrayList<List<String>>();
        this.seatBookings = seatBookings;
        this.theatreSeats = theatreSeats;
        createSeatMap();
    }

    private boolean isSeatOccupied(int row, int seat) {
        return seatBookings.stream().anyMatch((e) -> e.getSeatNumber() == seat+1 && e.getSeatRowNumber() == row+1);
    }

    private String getSeatType(int row, int seat) {
        return theatreSeats.stream()
                .filter((e) -> e.getTheatreSeatNumber() == seat+1 && e.getTheatreRowNumber() == row+1)
                .findFirst()
                .get()
                .getSeatType()
                .toString()
                .toLowerCase();
    }

    private int calcGridSize() {
        return theatreSeats.stream().map(TheatreSeat::getTheatreRowNumber).max(Integer::compare).get();
    }

    private void createSeatMap() {
        int size = calcGridSize();
        for (int i = 0; i < size; i++) {
            seatMap.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                if (isSeatOccupied(i, j)) {
                    seatMap.get(i).add("occupied");
                } else {
                    seatMap.get(i).add(getSeatType(i, j));
                }
            }
        }

    }
}
