package com.xen.camaya.controller;

import com.xen.camaya.model.UserModel;
import com.xen.camaya.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {

    public record SignUpRequest(String email, String username, String password, String phoneNumber) { }
    public record LoginResponse(String token) { }
    public record LoginRequest(String email, String password) { }

    private final LoginService loginService;

    @PostMapping("/signup")
    public ResponseEntity<UserModel> signUp(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(loginService.createCustomer(
                request.email(),
                request.username(),
                request.password(),
                request.phoneNumber()
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
         String token = loginService.authenticateCustomer(request.email(), request.password());
    }

}
