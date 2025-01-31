package com.tpe.JUnitWithSpringBoot.service;

import com.tpe.JUnitWithSpringBoot.domain.Customer;
import com.tpe.JUnitWithSpringBoot.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void getCustomerById() {
        Customer customer = new Customer();
        customer.setId(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        Customer foundCustomer = customerService.getCustomerById(1L);

        assertEquals(1L, foundCustomer.getId());
        verify(customerRepository).findById(1L);
    }

    @Test
    void deleteCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        customerService.deleteCustomer(1L);
        verify(customerRepository).delete(customer);
    }
}