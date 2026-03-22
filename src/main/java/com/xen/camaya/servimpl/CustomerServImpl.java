package com.xen.camaya.servimpl;

import com.xen.camaya.entity.Customer;
import com.xen.camaya.entity.Property;
import com.xen.camaya.model.PropertyModel;
import com.xen.camaya.repository.CustomerRepository;
import com.xen.camaya.repository.PropertyRepository;
import com.xen.camaya.service.CustomerService;
import com.xen.camaya.transformimpl.PropertyTransformImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@PreAuthorize( "hasRole('CUSTOMER')")
@Service
@RequiredArgsConstructor
public class CustomerServImpl implements CustomerService {

    private final PropertyRepository propertyRepository;
    private final CustomerRepository customerRepository;
    private final PropertyTransformImpl transform;

    @Override
    @Transactional
    public List<PropertyModel> addPropertyToCustomer(int customerId, int propertyId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        if (customer.getLinkedProperties().contains(property)) {
            throw new IllegalArgumentException("Property already linked");
        }

        property.setLinkedCustomer(customer);
        propertyRepository.save(property);

        return customer.getLinkedProperties().stream().map(transform::toModel).toList();
    }
}
