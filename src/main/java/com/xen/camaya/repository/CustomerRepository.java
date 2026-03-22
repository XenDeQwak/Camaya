package com.xen.camaya.repository;

import com.xen.camaya.entity.Customer;
import com.xen.camaya.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerByEmail(String email);
}
