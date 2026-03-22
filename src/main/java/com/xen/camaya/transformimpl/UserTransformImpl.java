package com.xen.camaya.transformimpl;

import com.xen.camaya.entity.User;
import com.xen.camaya.model.UserModel;
import com.xen.camaya.transform.UserTransform;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserTransformImpl implements UserTransform {

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public User toEntity(UserModel model) {
        return mapper.map(model, User.class);
    }

    @Override
    public UserModel toModel(User entity) {
        return mapper.map(entity, UserModel.class);
    }
}
