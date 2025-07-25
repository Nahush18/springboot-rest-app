package com.oracle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oracle.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
