package com.comodif.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comodif.challenge.entity.Seat;
import com.comodif.challenge.repository.SeatRepository;
import java.util.List;


@Service
public class SeatService {
    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat getSeatById(Long id) {
        return seatRepository.findById(id).orElse(null);
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat updateSeat(Long id, Seat seat) {
        Seat existingSeat = seatRepository.findById(id).orElse(null);
        if (existingSeat != null) {
            existingSeat.setSeatNumber(seat.getSeatNumber());
            existingSeat.setOccupied(seat.isOccupied());
            return seatRepository.save(existingSeat);
        }
        return null;
    }

    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }
}

