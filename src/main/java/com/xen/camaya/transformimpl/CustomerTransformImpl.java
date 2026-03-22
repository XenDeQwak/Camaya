package com.xen.camaya.transformimpl;

import com.xen.camaya.entity.Customer;
import com.xen.camaya.model.CustomerModel;
import com.xen.camaya.transform.CustomerTransform;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerTransformImpl implements CustomerTransform {
    private final ModelMapper mapper = new ModelMapper();


    @Override
    public Customer toEntity(CustomerModel model) {
        return mapper.map(model, Customer.class);
    }

    @Override
    public CustomerModel toModel(Customer entity) {
        return mapper.map(entity, CustomerModel.class);
    }
}
