package com.comodif.challenge.dto;

import com.comodif.challenge.entity.Payment;
import com.comodif.challenge.entity.Reservation;
import lombok.Data;

@Data
public class ReservationDto {
    private Long id;
    private CustomerDto customerDto;
    private FlightDto flightDto;
    private PaymentDto paymentDto;
    private TicketDto ticketDto;
    private SeatDto seatDto;

}
