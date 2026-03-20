package com.xen.camaya.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AdminModel extends UserModel {
    private List<CustomerModel> linkedCustomers;
}
