package com.xen.camaya.servimpl;

import com.xen.camaya.entity.Property;
import com.xen.camaya.model.PropertyModel;
import com.xen.camaya.repository.PropertyRepository;
import com.xen.camaya.service.PropertyService;
import com.xen.camaya.transformimpl.PropertyTransformImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyServImpl implements PropertyService {

    private final PropertyTransformImpl propertyTransform;
    private final PropertyRepository propertyRepository;

    @Override
    public PropertyModel addProperty(String name, String description, String address, double price) {
        if (propertyRepository.findByNameAndAddress(name, address) == null) {
            Property property = new Property();
            property.setName(name);
            property.setDescription(description);
            property.setAddress(address);
            property.setPrice(price);
            propertyRepository.save(property);
            return propertyTransform.toModel(property);
        } else {
            throw new RuntimeException("Property already exists");
        }
    }
}
