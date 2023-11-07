package com.comodif.challenge.service;

import com.comodif.challenge.dto.ReservationDto;
import com.comodif.challenge.entity.Reservation;
import com.comodif.challenge.repository.ReservationRepository;
import com.comodif.challenge.service.mapper.ReservationMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReservationServiceTest {

    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private ReservationMapper reservationMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        reservationService = new ReservationService(reservationRepository, reservationMapper);
    }

    @Test
    public void testGetAllReservations() {
        Reservation reservation1 = new Reservation();
        Reservation reservation2 = new Reservation();
        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(reservation1);
        reservationList.add(reservation2);

        when(reservationRepository.findAll()).thenReturn(reservationList);

        ReservationDto reservationDto1 = new ReservationDto();
        ReservationDto reservationDto2 = new ReservationDto();
        when(reservationMapper.toDTO(reservation1)).thenReturn(reservationDto1);
        when(reservationMapper.toDTO(reservation2)).thenReturn(reservationDto2);

        List<ReservationDto> result = reservationService.getAllReservations();

        assertEquals(2, result.size());
        assertEquals(reservationDto1, result.get(0));
        assertEquals(reservationDto2, result.get(1));
    }

}
