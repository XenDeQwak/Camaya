package com.xen.camaya.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyModel {
    private int id;
    private String name;
    private String description;
    private String address;
    private double price;

    private CustomerModel linkedCustomer;
}
