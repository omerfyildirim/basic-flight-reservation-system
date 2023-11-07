package com.comodif.challenge.service;

import com.comodif.challenge.dto.ReservationDto;
import com.comodif.challenge.entity.Reservation;
import com.comodif.challenge.repository.ReservationRepository;
import com.comodif.challenge.service.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    public List<ReservationDto> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservationMapper.toDTO(reservations);
    }

    public ReservationDto getReservationById(Long id) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        return reservationOptional.map(reservationMapper::toDTO).orElse(null);
    }

    public void createReservation(ReservationDto reservationDto) {
        Reservation reservation = reservationMapper.toEntity(reservationDto);
        reservationRepository.save(reservation);
    }

    public void updateReservation(Long id, ReservationDto reservationDto) {
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        reservationOptional.ifPresent(existingReservation -> {
            Reservation updatedReservation = reservationMapper.toEntity(reservationDto);
            updatedReservation.setId(existingReservation.getId());
            reservationRepository.save(updatedReservation);
        });
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
