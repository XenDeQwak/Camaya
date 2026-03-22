package com.xen.camaya.service;

import com.xen.camaya.model.UserModel;

public interface UserService {
    UserModel createUser(String email, String username, String password);
    boolean authenticateUser(String email, String password);
}
