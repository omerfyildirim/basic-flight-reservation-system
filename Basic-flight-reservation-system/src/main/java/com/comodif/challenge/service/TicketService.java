package com.comodif.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.comodif.challenge.entity.Ticket;
import com.comodif.challenge.repository.TicketRepository;
import java.util.List;


@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket ticket) {
        Ticket existingTicket = ticketRepository.findById(id).orElse(null);
        if (existingTicket != null) {
            existingTicket.setFlight(ticket.getFlight());
            existingTicket.setSeat(ticket.getSeat());
            existingTicket.setCustomer(ticket.getCustomer());
            existingTicket.setIssueTime(ticket.getIssueTime());
            existingTicket.setPayment(ticket.getPayment());
            return ticketRepository.save(existingTicket);
        }
        return null;
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}

