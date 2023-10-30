package com.comodif.challenge.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Long> reservationIds;
    private List<Long> paymentIds;
    private Long ticketId;
    private Long flightId;
    private List<Long> seatIds;
}
