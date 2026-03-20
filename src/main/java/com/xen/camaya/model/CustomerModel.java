package com.xen.camaya.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerModel extends UserModel {
    private AdminModel linkedAdmin;
    private List<PropertyModel> linkedProperties;
    private String phoneNumber;
}
