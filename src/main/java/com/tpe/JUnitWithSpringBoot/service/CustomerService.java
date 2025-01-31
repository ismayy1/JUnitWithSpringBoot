package com.tpe.JUnitWithSpringBoot.service;

import com.tpe.JUnitWithSpringBoot.domain.Customer;
import com.tpe.JUnitWithSpringBoot.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("No Customer found with given ID: " + id));
    }

    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);

        customerRepository.delete(customer);
    }
}
