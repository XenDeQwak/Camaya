package com.xen.camaya.repository;

import com.xen.camaya.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
    Property findByNameAndAddress(String name, String address);
}
