package com.comodif.challenge.service.mapper;

import com.comodif.challenge.dto.CustomerDto;
import com.comodif.challenge.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private ReservationMapper reservationMapper;
    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private FlightMapper flightMapper;

    public Customer toEntity(CustomerDto customerDto){
        if (customerDto == null){
            return null;
        }

        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setReservations(reservationMapper.toEntity(customerDto.getReservations()));
        customer.setPayments(paymentMapper.toEntity(customerDto.getPayments()));
        customer.setTicket(ticketMapper.toEntity(customerDto.getTicket()));
        customer.setFlight(flightMapper.toEntity(customerDto.getFlight()));
        customer.setSeats(seatMapper.toEntity(customerDto.getSeats()));

        return customer;
    }

    public CustomerDto toDTO(Customer customer){
        if (customer == null){
            return null;
        }

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setReservations(reservationMapper.toDTO(customer.getReservations()));
        customerDto.setPayments(paymentMapper.toDTO(customer.getPayments()));
        customerDto.setTicket(ticketMapper.toDTO(customer.getTicket()));
        customerDto.setFlight(flightMapper.toDTO(customer.getFlight()));
        customerDto.setSeats(seatMapper.toDTO(customer.getSeats()));

        return customerDto;
    }

    public List<CustomerDto> toDTO(List<Customer> customerList){
        if (customerList == null){
            return null;
        }

        List<CustomerDto> customerDtoList = new ArrayList<>(customerList.size());
        for (Customer customer : customerList){
            customerDtoList.add(toDTO(customer));
        }

        return customerDtoList;
    }


    public List<Customer> toEntity(List<CustomerDto> customerDtoList){
        if (customerDtoList == null){
            return null;
        }

        List<Customer> customerList = new ArrayList<>(customerDtoList.size());
        for (CustomerDto customerDto : customerDtoList){
            customerList.add(toEntity(customerDto));
        }

        return customerList;
    }



}
