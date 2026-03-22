package com.xen.camaya.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends User {
    @ManyToOne
    @JoinColumn(name = "linked_admin_id")
    private Admin linkedAdmin;

    @OneToMany(mappedBy = "linkedCustomer", cascade = CascadeType.ALL)
    private List<Property> linkedProperties = new ArrayList<>();

    @Column(unique = true)
    private String phoneNumber;
}
