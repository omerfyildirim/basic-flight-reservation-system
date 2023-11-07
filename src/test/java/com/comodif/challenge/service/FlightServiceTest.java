package com.comodif.challenge.service;

import com.comodif.challenge.dto.FlightDto;
import com.comodif.challenge.entity.Flight;
import com.comodif.challenge.repository.FlightRepository;
import com.comodif.challenge.service.mapper.FlightMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FlightServiceTest {

    private FlightService flightService;

    @Mock
    private FlightRepository flightRepository;

    @Mock
    private FlightMapper flightMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        flightService = new FlightService(flightRepository, flightMapper);
    }

    @Test
    public void testGetAllFlights() {
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        List<Flight> flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);

        when(flightRepository.findAll()).thenReturn(flightList);

        FlightDto flightDto1 = new FlightDto();
        FlightDto flightDto2 = new FlightDto();
        when(flightMapper.toDTO(flight1)).thenReturn(flightDto1);
        when(flightMapper.toDTO(flight2)).thenReturn(flightDto2);

        List<FlightDto> result = flightService.getAllFlights();

        assertEquals(2, result.size());
        assertEquals(flightDto1, result.get(0));
        assertEquals(flightDto2, result.get(1));
    }

}
