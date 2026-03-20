package com.xen.camaya.model;

import com.xen.camaya.util.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
    private int id;
    private String email;
    private String password;
    private String name;

    private Role role;
}
