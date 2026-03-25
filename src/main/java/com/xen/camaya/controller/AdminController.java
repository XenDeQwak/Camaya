package com.xen.camaya.controller;

import com.xen.camaya.model.PropertyModel;
import com.xen.camaya.service.AdminService;
import com.xen.camaya.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final PropertyService propertyService;

    public record PropertyRequest(String name,
                                  String description,
                                  String address,
                                  double price) { }

    @PostMapping("/add-property")
    public ResponseEntity<PropertyModel> addProperty(@RequestBody PropertyRequest request) {
        return ResponseEntity.ok(propertyService.addProperty(
                        request.name(),
                        request.description(),
                        request.address(),
                        request.price()
                )
        );
    }
}
