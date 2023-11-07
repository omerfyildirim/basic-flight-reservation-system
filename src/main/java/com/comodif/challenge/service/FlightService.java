package com.comodif.challenge.service;

import com.comodif.challenge.dto.FlightDto;
import com.comodif.challenge.entity.Flight;
import com.comodif.challenge.repository.FlightRepository;
import com.comodif.challenge.service.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    private final FlightMapper flightMapper;

    @Autowired
    public FlightService(FlightRepository flightRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
    }

    public List<FlightDto> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flightMapper.toDTO(flights);
    }

    public FlightDto getFlightById(Long id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        return flightOptional.map(flightMapper::toDTO).orElse(null);
    }

    public void createFlight(FlightDto flightDto) {
        Flight flight = flightMapper.toEntity(flightDto);
        flightRepository.save(flight);
    }

    public void updateFlight(Long id, FlightDto flightDto) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        flightOptional.ifPresent(existingFlight -> {
            Flight updatedFlight = flightMapper.toEntity(flightDto);
            updatedFlight.setId(existingFlight.getId());
            flightRepository.save(updatedFlight);
        });
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
