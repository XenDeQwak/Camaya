package com.xen.camaya.service;

import com.xen.camaya.model.PropertyModel;

import java.util.List;

public interface CustomerService {
    List<PropertyModel> addPropertyToCustomer(int customerId, int propertyId);
}
