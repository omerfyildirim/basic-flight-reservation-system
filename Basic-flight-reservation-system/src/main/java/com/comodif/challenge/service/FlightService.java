package com.comodif.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comodif.challenge.entity.Flight;
import com.comodif.challenge.repository.FlightRepository;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight) {
        Flight existingFlight = flightRepository.findById(id).orElse(null);
        if (existingFlight != null) {
            existingFlight.setFlightNumber(flight.getFlightNumber());
            existingFlight.setOrigin(flight.getOrigin());
            existingFlight.setDestination(flight.getDestination());
            existingFlight.setDepartureTime(flight.getDepartureTime());
            existingFlight.setArrivalTime(flight.getArrivalTime());
            return flightRepository.save(existingFlight);
        }
        return null;
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}

