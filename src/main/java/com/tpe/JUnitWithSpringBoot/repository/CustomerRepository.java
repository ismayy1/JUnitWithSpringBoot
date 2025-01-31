package com.tpe.JUnitWithSpringBoot.repository;

import com.tpe.JUnitWithSpringBoot.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
