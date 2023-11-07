package com.comodif.challenge.service;

import com.comodif.challenge.dto.SeatDto;
import com.comodif.challenge.entity.Seat;
import com.comodif.challenge.repository.SeatRepository;
import com.comodif.challenge.service.mapper.SeatMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class SeatServiceTest {

    private SeatService seatService;

    @Mock
    private SeatRepository seatRepository;

    @Mock
    private SeatMapper seatMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        seatService = new SeatService(seatRepository, seatMapper);
    }

    @Test
    public void testGetAllSeats() {
        Seat seat1 = new Seat();
        Seat seat2 = new Seat();
        List<Seat> seatList = new ArrayList<>();
        seatList.add(seat1);
        seatList.add(seat2);

        when(seatRepository.findAll()).thenReturn(seatList);

        SeatDto seatDto1 = new SeatDto();
        SeatDto seatDto2 = new SeatDto();
        when(seatMapper.toDTO(seat1)).thenReturn(seatDto1);
        when(seatMapper.toDTO(seat2)).thenReturn(seatDto2);

        List<SeatDto> result = seatService.getAllSeats();

        assertEquals(2, result.size());
        assertEquals(seatDto1, result.get(0));
        assertEquals(seatDto2, result.get(1));
    }

}
