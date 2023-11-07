package com.comodif.challenge.service.mapper;

import com.comodif.challenge.dto.SeatDto;
import com.comodif.challenge.entity.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeatMapper {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private PaymentMapper paymentMapper;

    public SeatDto toDTO(Seat seat){
        if (seat == null){
            return null;
        }

        SeatDto seatDto = new SeatDto();
        seatDto.setId(seat.getId());
        seatDto.setSeatNumber(seat.getSeatNumber());
        seatDto.setOccupied(seat.isOccupied());
        seatDto.setCustomerDto(customerMapper.toDTO(seat.getCustomer()));
        seatDto.setFlightDto(flightMapper.toDTO(seat.getFlight()));
        seatDto.setPaymentDto(paymentMapper.toDTO(seat.getPayment()));
        seatDto.setReservationDto(reservationMapper.toDTO(seat.getReservation()));
        seatDto.setTicketDto(ticketMapper.toDTO(seat.getTicket()));

        return seatDto;
    }

    public Seat toEntity(SeatDto seatDto){
        if (seatDto == null){
            return null;
        }

        Seat seat = new Seat();
        seat.setId(seatDto.getId());
        seat.setSeatNumber(seatDto.getSeatNumber());
        seat.setOccupied(seatDto.isOccupied());
        seat.setCustomer(customerMapper.toEntity(seatDto.getCustomerDto()));
        seat.setFlight(flightMapper.toEntity(seatDto.getFlightDto()));
        seat.setPayment(paymentMapper.toEntity(seatDto.getPaymentDto()));
        seat.setReservation(reservationMapper.toEntity(seatDto.getReservationDto()));
        seat.setTicket(ticketMapper.toEntity(seatDto.getTicketDto()));

        return seat;
    }

    public List<Seat> toEntity(List<SeatDto> seatDtoList){
        if (seatDtoList == null){
            return null;
        }

        List<Seat> seatList = new ArrayList<>(seatDtoList.size());
        for (SeatDto seatDto : seatDtoList){
            seatList.add(toEntity(seatDto));
        }

        return seatList;
    }

    public List<SeatDto> toDTO(List<Seat> seatList){
        if (seatList == null){
            return null;
        }

        List<SeatDto> seatDtoList = new ArrayList<>(seatList.size());
        for (Seat seat : seatList){
            seatDtoList.add(toDTO(seat));
        }

        return seatDtoList;
    }
}
