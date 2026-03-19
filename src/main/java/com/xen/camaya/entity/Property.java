package com.xen.camaya.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String address;
    private double price;

    @ManyToOne
    @JoinColumn(name = "linked_customer_id")
    private Customer linkedCustomer;
}
