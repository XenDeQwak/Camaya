package com.xen.camaya.transformimpl;

import com.xen.camaya.entity.Property;
import com.xen.camaya.model.PropertyModel;
import com.xen.camaya.transform.PropertyTransform;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PropertyTransformImpl implements PropertyTransform {

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public Property toEntity(PropertyModel model) {
        return mapper.map(model, Property.class);
    }

    @Override
    public PropertyModel toModel(Property entity) {
        return mapper.map(entity, PropertyModel.class);
    }
}
