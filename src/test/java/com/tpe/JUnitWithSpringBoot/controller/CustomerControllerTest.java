package com.tpe.JUnitWithSpringBoot.controller;

import com.tpe.JUnitWithSpringBoot.domain.Customer;
import com.tpe.JUnitWithSpringBoot.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    void getCustomerById() {
        Customer customer = new Customer();
        customer.setId(1L);

        when(customerService.getCustomerById(1L)).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.getCustomerById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
        verify(customerService).getCustomerById(1L);
    }

    @Test
    void deleteCustomerById() {
        ResponseEntity<Map<String, Object>> response = customerController.deleteCustomerById(2L);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "Customer deleted successfully.");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(map, response.getBody());
        verify(customerService).deleteCustomer(2L);
    }
}