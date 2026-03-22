package com.xen.camaya.controller;

import com.xen.camaya.model.UserModel;
import com.xen.camaya.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    public record SignUpRequest(String email, String username, String password) { }
    public record LoginRequest(String email, String password) { }

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserModel> signUp(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(userService.createUser(request.email(), request.username(), request.password()));
    }

    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.authenticateUser(request.email(), request.password()));
    }


}
