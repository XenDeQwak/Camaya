package com.xen.camaya.transformimpl;

import com.xen.camaya.entity.Admin;
import com.xen.camaya.model.AdminModel;
import com.xen.camaya.transform.AdminTransform;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminTransformImpl implements AdminTransform {
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public Admin toEntity(AdminModel model) {
        return mapper.map(model, Admin.class);
    }

    @Override
    public AdminModel toModel(Admin entity) {
        return mapper.map(entity, AdminModel.class);
    }
}
