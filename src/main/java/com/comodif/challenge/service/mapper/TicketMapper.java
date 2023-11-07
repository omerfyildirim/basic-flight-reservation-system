package com.comodif.challenge.service.mapper;

import com.comodif.challenge.dto.TicketDto;
import com.comodif.challenge.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketMapper {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    private PaymentMapper paymentMapper;

    public TicketDto toDTO(Ticket ticket){
        if (ticket == null){
            return null;
        }

        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setCustomerDto(customerMapper.toDTO(ticket.getCustomer()));
        ticketDto.setFlightDto(flightMapper.toDTO(ticket.getFlight()));
        ticketDto.setPaymentDto(paymentMapper.toDTO(ticket.getPayment()));
        ticketDto.setReservationDto(reservationMapper.toDTO(ticket.getReservation()));
        ticketDto.setSeatDto(seatMapper.toDTO(ticket.getSeat()));

        return ticketDto;
    }

    public Ticket toEntity(TicketDto ticketDto){
        if (ticketDto == null){
            return null;
        }

        Ticket ticket = new Ticket();
        ticket.setId(ticketDto.getId());
        ticket.setCustomer(customerMapper.toEntity(ticketDto.getCustomerDto()));
        ticket.setFlight(flightMapper.toEntity(ticketDto.getFlightDto()));
        ticket.setPayment(paymentMapper.toEntity(ticketDto.getPaymentDto()));
        ticket.setReservation(reservationMapper.toEntity(ticketDto.getReservationDto()));
        ticket.setSeat(seatMapper.toEntity(ticketDto.getSeatDto()));

        return ticket;
    }

    public List<TicketDto> toDTO(List<Ticket> ticketList){
        if (ticketList == null){
            return null;
        }

        List<TicketDto> ticketDtoList = new ArrayList<>(ticketList.size());
        for (Ticket ticket : ticketList){
            ticketDtoList.add(toDTO(ticket));
        }

        return ticketDtoList;
    }

    public List<Ticket> toEntity(List<TicketDto> ticketDtoList){
        if (ticketDtoList == null){
            return null;
        }

        List<Ticket> ticketList = new ArrayList<>(ticketDtoList.size());
        for (TicketDto ticketDto : ticketDtoList){
            ticketList.add(toEntity(ticketDto));
        }

        return ticketList;
    }
}
