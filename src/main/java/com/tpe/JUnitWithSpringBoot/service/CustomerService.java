package com.tpe.JUnitWithSpringBoot.service;

import com.tpe.JUnitWithSpringBoot.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
}
