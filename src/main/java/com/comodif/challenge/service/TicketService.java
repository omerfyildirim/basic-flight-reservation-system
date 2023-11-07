package com.comodif.challenge.service;

import com.comodif.challenge.dto.TicketDto;
import com.comodif.challenge.entity.Ticket;
import com.comodif.challenge.repository.TicketRepository;
import com.comodif.challenge.service.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public List<TicketDto> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        List<TicketDto> ticketDtoList = ticketMapper.toDTO(tickets);
        return ticketDtoList;
    }

    public TicketDto getTicketById(Long id) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        return ticketOptional.map(ticketMapper::toDTO).orElse(null);
    }

    public void createTicket(TicketDto ticketDto) {
        Ticket ticket = ticketMapper.toEntity(ticketDto);
        ticketRepository.save(ticket);
    }

    public void updateTicket(Long id, TicketDto ticketDto) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(id);
        ticketOptional.ifPresent(existingTicket -> {
            Ticket updatedTicket = ticketMapper.toEntity(ticketDto);
            updatedTicket.setId(existingTicket.getId());
            ticketRepository.save(updatedTicket);
        });
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
