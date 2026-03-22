package com.xen.camaya.transform;

import com.xen.camaya.entity.User;
import com.xen.camaya.model.UserModel;

public interface UserTransform {
    User toEntity(UserModel model);
    UserModel toModel(User entity);
}
