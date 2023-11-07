package com.comodif.challenge.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentDto {
    private Long id;
    private BigDecimal price;
    private String bankResponse;
    private LocalDateTime paymentTime;
    private CustomerDto customerDto;
    private FlightDto flightDto;
    private ReservationDto reservationDto;
    private TicketDto ticketDto;
    private SeatDto seatDto;
}
