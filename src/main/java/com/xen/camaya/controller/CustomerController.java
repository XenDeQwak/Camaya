package com.xen.camaya.controller;

import com.xen.camaya.model.AdminModel;
import com.xen.camaya.model.PropertyModel;
import com.xen.camaya.service.AdminService;
import com.xen.camaya.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final AdminService adminService;

    public record CustomerPropertyRequest(int customerId, int propertyId) { }
    public record CustomerAdminConnectionRequest(int customerId, int adminId) { }

    @PostMapping("/add-property")
    public ResponseEntity<List<PropertyModel>> addPropertyToCustomer(@RequestBody CustomerPropertyRequest request) {
        return ResponseEntity.ok(customerService.addPropertyToCustomer(request.customerId(), request.propertyId()));
    }

    @PostMapping("/connect-admin")
    public ResponseEntity<AdminModel> connectToAdmin(@RequestBody CustomerAdminConnectionRequest request) {
        return ResponseEntity.ok(adminService.addCustomer(request.customerId(), request.adminId()));
    }

}
