package com.xen.camaya.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer extends User {
    @ManyToOne
    @JoinColumn(name = "linked_admin_id")
    private Admin linkedAdmin;
}
