package com.comodif.challenge.dto;

import com.comodif.challenge.entity.Reservation;
import lombok.Data;

@Data
public class ReservationDto {
    private Long id;
    private Long customerId;
    private Long flightId;
    private Long paymentId;
    private Long ticketId;
    private Long seatId;


    public Reservation toEntity() {
        Reservation reservation = new Reservation();
        wereservation.setId(id);
        reservation.setCustomerId(customerId);
        return reservation;
    }

    public static ReservationDto fromEntity(Reservation reservation) {
        ReservationDto dto = new ReservationDto();
        dto.setId(reservation.getId());
        dto.setCustomerId(reservation.getCustomerId());
        return dto;
    }

}
