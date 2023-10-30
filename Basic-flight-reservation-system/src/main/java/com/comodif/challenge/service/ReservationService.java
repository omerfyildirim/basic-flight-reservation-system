package com.comodif.challenge.service;

import com.comodif.challenge.dto.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comodif.challenge.entity.Reservation;
import com.comodif.challenge.repository.ReservationRepository;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Long id, ReservationDto reservation) {
        Reservation existingReservation = reservationRepository.findById(id).orElse(null);
        if (existingReservation != null) {
            existingReservation.setFlight(reservation.getFlight());
            existingReservation.setCustomer(reservation.getCustomer());
            existingReservation.setNumberOfPassengers(reservation.getNumberOfPassengers());
            existingReservation.setReservationTime(reservation.getReservationTime());
            return reservationRepository.save(existingReservation);
        }
        return null;
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}

