package com.xen.camaya.controller;

import com.xen.camaya.model.PropertyModel;
import com.xen.camaya.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    public record CustomerPropertyRequest(int customerId, int propertyId) { }

    @PostMapping("/add-property")
    public ResponseEntity<List<PropertyModel>> addPropertyToCustomer(@RequestBody CustomerPropertyRequest request) {
        return ResponseEntity.ok(customerService.addPropertyToCustomer(request.customerId(), request.propertyId()));
    }

}
