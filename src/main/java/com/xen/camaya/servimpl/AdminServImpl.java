package com.xen.camaya.servimpl;

import com.xen.camaya.entity.Admin;
import com.xen.camaya.entity.Customer;
import com.xen.camaya.model.AdminModel;
import com.xen.camaya.repository.AdminRepository;
import com.xen.camaya.repository.CustomerRepository;
import com.xen.camaya.service.AdminService;
import com.xen.camaya.transformimpl.AdminTransformImpl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServImpl implements AdminService {

    private final CustomerRepository customerRepository;
    private final AdminRepository adminRepository;
    private final AdminTransformImpl transform;

    @Override
    @Transactional
    public AdminModel addCustomer(int customerId, int adminId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        Admin admin = adminRepository.findById(adminId).orElseThrow();

        if (customer.getLinkedAdmin() != null) {
            throw new RuntimeException("Customer already linked to an admin");
        }

        customer.setLinkedAdmin(admin);
        customerRepository.save(customer);

        return transform.toModel(admin);
    }
}
