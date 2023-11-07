package com.comodif.challenge.service;

import com.comodif.challenge.dto.SeatDto;
import com.comodif.challenge.entity.Seat;
import com.comodif.challenge.repository.SeatRepository;
import com.comodif.challenge.service.mapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SeatService {
    private final SeatRepository seatRepository;
    private final SeatMapper seatMapper;

    @Autowired
    public SeatService(SeatRepository seatRepository, SeatMapper seatMapper) {
        this.seatRepository = seatRepository;
        this.seatMapper = seatMapper;
    }

    public List<SeatDto> getAllSeats() {
        List<Seat> seats = seatRepository.findAll();
        return seatMapper.toDTO(seats);
    }

    public SeatDto getSeatById(Long id) {
        Optional<Seat> seatOptional = seatRepository.findById(id);
        return seatOptional.map(seatMapper::toDTO).orElse(null);
    }

    public void createSeat(SeatDto seatDto) {
        Seat seat = seatMapper.toEntity(seatDto);
        seatRepository.save(seat);
    }

    public void updateSeat(Long id, SeatDto seatDto) {
        Optional<Seat> seatOptional = seatRepository.findById(id);
        seatOptional.ifPresent(existingSeat -> {
            Seat updatedSeat = seatMapper.toEntity(seatDto);
            updatedSeat.setId(existingSeat.getId());
            seatRepository.save(updatedSeat);
        });
    }

    public void deleteSeat(Long id) {
        seatRepository.deleteById(id);
    }
}
