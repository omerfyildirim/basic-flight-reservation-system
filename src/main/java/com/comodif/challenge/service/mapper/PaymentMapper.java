package com.comodif.challenge.service.mapper;

import com.comodif.challenge.dto.PaymentDto;
import com.comodif.challenge.dto.ReservationDto;
import com.comodif.challenge.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentMapper {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private ReservationMapper reservationMapper;

    public PaymentDto toDTO(Payment payment){
        if (payment == null){
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(payment.getId());
        paymentDto.setPrice(payment.getPrice());
        paymentDto.setBankResponse(payment.getBankResponse());
        paymentDto.setPaymentTime(payment.getPaymentTime());
        paymentDto.setCustomerDto(customerMapper.toDTO(payment.getCustomer()));
        paymentDto.setFlightDto(flightMapper.toDTO(payment.getFlight()));
        paymentDto.setReservationDto(reservationMapper.toDTO(payment.getReservation()));
        paymentDto.setTicketDto(ticketMapper.toDTO(payment.getTicket()));
        paymentDto.setSeatDto(seatMapper.toDTO(payment.getSeat()));

        return paymentDto;
    }

    public Payment toEntity(PaymentDto paymentDto){
        if (paymentDto == null){
            return null;
        }

        Payment payment = new Payment();
        payment.setId(paymentDto.getId());
        payment.setPrice(paymentDto.getPrice());
        payment.setBankResponse(paymentDto.getBankResponse());
        payment.setPaymentTime(paymentDto.getPaymentTime());
        payment.setCustomer(customerMapper.toEntity(paymentDto.getCustomerDto()));
        payment.setFlight(flightMapper.toEntity(paymentDto.getFlightDto()));
        payment.setReservation(reservationMapper.toEntity(paymentDto.getReservationDto()));
        payment.setTicket(ticketMapper.toEntity(paymentDto.getTicketDto()));
        payment.setSeat(seatMapper.toEntity(paymentDto.getSeatDto()));

        return payment;
    }

    public List<PaymentDto> toDTO(List<Payment> paymentList){
        if (paymentList == null){
            return null;
        }

        List<PaymentDto> paymentDtoList = new ArrayList<>(paymentList.size());
        for (Payment payment : paymentList){
            paymentDtoList.add(toDTO(payment));
        }

        return paymentDtoList;
    }

    public List<Payment> toEntity(List<PaymentDto> paymentDtoList){
        if (paymentDtoList == null){
            return null;
        }

        List<Payment> paymentList = new ArrayList<>(paymentDtoList.size());
        for (PaymentDto paymentDto : paymentDtoList){
            paymentList.add(toEntity(paymentDto));
        }

        return paymentList;
    }
}
