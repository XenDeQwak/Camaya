package com.xen.camaya.service;

import com.xen.camaya.model.PropertyModel;

public interface PropertyService {
    PropertyModel addProperty(String name, String description, String address, double price);
}
