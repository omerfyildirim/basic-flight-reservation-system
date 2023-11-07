package com.comodif.challenge.service;

import com.comodif.challenge.dto.CustomerDto;
import com.comodif.challenge.entity.Customer;
import com.comodif.challenge.repository.CustomerRepository;
import com.comodif.challenge.service.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.toDTO(customers);
    }

    public CustomerDto getCustomerById(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.map(customerMapper::toDTO).orElse(null);
    }

    public void createCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        customerRepository.save(customer);
    }

    public void updateCustomer(Long id, CustomerDto customerDto) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        customerOptional.ifPresent(existingCustomer -> {
            Customer updatedCustomer = customerMapper.toEntity(customerDto);
            updatedCustomer.setId(existingCustomer.getId());
            customerRepository.save(updatedCustomer);
        });
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
