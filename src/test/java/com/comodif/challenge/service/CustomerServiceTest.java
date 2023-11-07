package com.comodif.challenge.service;

import com.comodif.challenge.dto.CustomerDto;
import com.comodif.challenge.entity.Customer;
import com.comodif.challenge.repository.CustomerRepository;
import com.comodif.challenge.service.CustomerService;
import com.comodif.challenge.service.mapper.CustomerMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CustomerServiceTest {

    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        customerService = new CustomerService(customerRepository, customerMapper);
    }

    @Test
    public void testGetAllCustomers() {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        when(customerRepository.findAll()).thenReturn(customerList);

        CustomerDto customerDto1 = new CustomerDto();
        CustomerDto customerDto2 = new CustomerDto();
        when(customerMapper.toDTO(customer1)).thenReturn(customerDto1);
        when(customerMapper.toDTO(customer2)).thenReturn(customerDto2);

        List<CustomerDto> result = customerService.getAllCustomers();

        assertEquals(2, result.size());
        assertEquals(customerDto1, result.get(0));
        assertEquals(customerDto2, result.get(1));
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer();
        Long customerId = 1L;

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));

        CustomerDto customerDto = new CustomerDto();
        when(customerMapper.toDTO(customer)).thenReturn(customerDto);

        CustomerDto result = customerService.getCustomerById(customerId);

        assertEquals(customerDto, result);
    }


    @Test
    public void testDeleteCustomer() {
        Long customerId = 1L;

        customerService.deleteCustomer(customerId);

        verify(customerRepository, times(1)).deleteById(customerId);
    }
}
