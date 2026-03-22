package com.xen.camaya.transform;

import com.xen.camaya.entity.Customer;
import com.xen.camaya.model.CustomerModel;

public interface CustomerTransform {
    Customer toEntity(CustomerModel model);
    CustomerModel toModel(Customer entity);
}
