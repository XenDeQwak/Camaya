package com.xen.camaya.transform;

import com.xen.camaya.entity.Property;
import com.xen.camaya.model.PropertyModel;

public interface PropertyTransform {
    Property toEntity(PropertyModel model);
    PropertyModel toModel(Property entity);
}
