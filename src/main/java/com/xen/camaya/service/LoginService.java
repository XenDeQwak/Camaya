package com.xen.camaya.service;

import com.xen.camaya.model.UserModel;

public interface LoginService {
    UserModel createCustomer(String email, String username, String password, String phoneNumber);
    boolean authenticateCustomer(String email, String password);
}
