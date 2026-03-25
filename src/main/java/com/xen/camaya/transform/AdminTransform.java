package com.xen.camaya.transform;

import com.xen.camaya.entity.Admin;
import com.xen.camaya.model.AdminModel;

public interface AdminTransform {
    Admin toEntity(AdminModel model);
    AdminModel toModel(Admin entity);
}
