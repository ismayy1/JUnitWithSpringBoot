package com.tpe.JUnitWithSpringBoot.controller;

import com.tpe.JUnitWithSpringBoot.domain.Customer;
import com.tpe.JUnitWithSpringBoot.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customer")
//@RequiredArgsConstructor
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerService.getCustomerById(id);

        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomer(id);

        Map<String, Object> map = new HashMap<>();
        map.put("message", "Customer deleted successfully.");

                return ResponseEntity.ok(map);
    }
}
