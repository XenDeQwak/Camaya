package com.xen.camaya.controller;

import com.xen.camaya.model.UserModel;
import com.xen.camaya.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    public record SignUpRequest(String email, String username, String password) { }

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserModel> signUp(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(userService.createUser(request.email(), request.username(), request.password()));
    }


}
