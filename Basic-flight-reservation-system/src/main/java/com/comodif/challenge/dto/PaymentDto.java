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
    private Long customerId;
    private Long flightId;
    private Long reservationId;
    private Long ticketId;
    private Long seatId;
}
