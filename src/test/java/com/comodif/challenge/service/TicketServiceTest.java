package com.comodif.challenge.service;

import com.comodif.challenge.dto.TicketDto;
import com.comodif.challenge.entity.Ticket;
import com.comodif.challenge.repository.TicketRepository;
import com.comodif.challenge.service.mapper.TicketMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TicketServiceTest {

    private TicketService ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private TicketMapper ticketMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ticketService = new TicketService(ticketRepository, ticketMapper);
    }

    @Test
    public void testGetAllTickets() {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        List<Ticket> ticketList = new ArrayList<>();
        ticketList.add(ticket1);
        ticketList.add(ticket2);

        when(ticketRepository.findAll()).thenReturn(ticketList);

        TicketDto ticketDto1 = new TicketDto();
        TicketDto ticketDto2 = new TicketDto();
        //when(ticketMapper.toDTO(ticket1)).thenReturn(ticketDto1);
        //when(ticketMapper.toDTO(ticket2)).thenReturn(ticketDto2);

        List<TicketDto> result = ticketService.getAllTickets();

        assertEquals(2, result.size());
        assertEquals(ticketDto1, result.get(0));
        assertEquals(ticketDto2, result.get(1));
    }
}
