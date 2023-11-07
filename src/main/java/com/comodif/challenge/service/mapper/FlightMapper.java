package com.comodif.challenge.service.mapper;

import com.comodif.challenge.dto.FlightDto;
import com.comodif.challenge.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightMapper {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private PaymentMapper paymentMapper;

    public FlightDto toDTO(Flight flight){
        if (flight == null){
            return null;
        }

        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId());
        flightDto.setFlightNumber(flight.getFlightNumber());
        flightDto.setOrigin(flight.getOrigin());
        flightDto.setDestination(flight.getDestination());
        flightDto.setDepartureTime(flight.getDepartureTime());
        flightDto.setArrivalTime(flight.getArrivalTime());
        flightDto.setReservations(reservationMapper.toDTO(flight.getReservations()));
        flightDto.setTickets(ticketMapper.toDTO(flight.getTickets()));
        flightDto.setPayments(paymentMapper.toDTO(flight.getPayments()));
        flightDto.setSeats(seatMapper.toDTO(flight.getSeats()));

        return flightDto;
    }

    public Flight toEntity(FlightDto flightDto){
        if (flightDto == null){
            return null;
        }

        Flight flight = new Flight();
        flight.setId(flightDto.getId());
        flight.setFlightNumber(flightDto.getFlightNumber());
        flight.setOrigin(flightDto.getOrigin());
        flight.setDestination(flightDto.getDestination());
        flight.setDepartureTime(flightDto.getDepartureTime());
        flight.setArrivalTime(flightDto.getArrivalTime());
        flight.setReservations(reservationMapper.toEntity(flightDto.getReservations()));
        flight.setTickets(ticketMapper.toEntity(flightDto.getTickets()));
        flight.setPayments(paymentMapper.toEntity(flightDto.getPayments()));
        flight.setSeats(seatMapper.toEntity(flightDto.getSeats()));

        return flight;
    }

    public List<FlightDto> toDTO(List<Flight> flightList){
        if (flightList == null){
            return null;
        }

        List<FlightDto> flightDtoList = new ArrayList<>(flightList.size());
        for (Flight flight : flightList){
            flightDtoList.add(toDTO(flight));
        }

        return flightDtoList;
    }

    public List<Flight> toEntity(List<FlightDto> flightDtoList){
        if (flightDtoList == null){
            return null;
        }

        List<Flight> flightList = new ArrayList<>(flightDtoList.size());
        for (FlightDto flightDto : flightDtoList){
            flightList.add(toEntity(flightDto));
        }

        return flightList;
    }
}
