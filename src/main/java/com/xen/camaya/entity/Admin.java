package com.xen.camaya.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "admins")
public class Admin extends User {
    private List<Customer> linkedCustomers;
}
