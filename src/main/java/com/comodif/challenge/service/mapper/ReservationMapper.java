package com.comodif.challenge.service.mapper;

import com.comodif.challenge.dto.ReservationDto;
import com.comodif.challenge.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationMapper {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private SeatMapper seatMapper;

    public ReservationDto toDTO(Reservation reservation){
        if (reservation == null){
            return null;
        }

        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setFlightDto(flightMapper.toDTO(reservation.getFlight()));
        reservationDto.setCustomerDto(customerMapper.toDTO(reservation.getCustomer()));
        reservationDto.setPaymentDto(paymentMapper.toDTO(reservation.getPayment()));
        reservationDto.setTicketDto(ticketMapper.toDTO(reservation.getTicket()));
        reservationDto.setSeatDto(seatMapper.toDTO(reservation.getSeat()));

        return reservationDto;

    }
    public Reservation toEntity(ReservationDto reservationDto){
        if (reservationDto == null){
            return null;
        }

        Reservation reservation = new Reservation();
        reservation.setId(reservationDto.getId());
        reservation.setFlight(flightMapper.toEntity(reservationDto.getFlightDto()));
        reservation.setCustomer(customerMapper.toEntity(reservationDto.getCustomerDto()));
        reservation.setPayment(paymentMapper.toEntity(reservationDto.getPaymentDto()));
        reservation.setTicket(ticketMapper.toEntity(reservationDto.getTicketDto()));
        reservation.setSeat(seatMapper.toEntity(reservationDto.getSeatDto()));

        return reservation;

    }

    public List<Reservation> toEntity(List<ReservationDto> reservationDtoList){
        if (reservationDtoList == null){
            return null;
        }

        List<Reservation> reservationList = new ArrayList<>(reservationDtoList.size());
        for (ReservationDto reservationDto : reservationDtoList){
            reservationList.add(toEntity(reservationDto));
        }

        return reservationList;
    }

    public List<ReservationDto> toDTO(List<Reservation> reservationList){
        if (reservationList == null){
            return null;
        }

        List<ReservationDto> reservationDtoList = new ArrayList<>(reservationList.size());
        for (Reservation reservation : reservationList){
            reservationDtoList.add(toDTO(reservation));
        }

        return reservationDtoList;
    }
}
