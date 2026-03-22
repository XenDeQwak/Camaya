package com.xen.camaya.servimpl;

import com.xen.camaya.entity.Customer;
import com.xen.camaya.entity.User;
import com.xen.camaya.model.UserModel;
import com.xen.camaya.repository.CustomerRepository;
import com.xen.camaya.repository.UserRepository;
import com.xen.camaya.service.LoginService;
import com.xen.camaya.transformimpl.CustomerTransformImpl;
import com.xen.camaya.util.JwtUtil;
import com.xen.camaya.util.Role;
import com.xen.camaya.util.configs.SecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServImpl implements LoginService {

    private final SecurityConfig securityConfig;
    private final CustomerRepository customerRepository;
    private final CustomerTransformImpl customerTransform;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    public UserModel createCustomer(String email, String username, String password, String phoneNumber) {
        if (customerRepository.findCustomerByEmail(email) == null) {
            Customer customer = new Customer();
            customer.setEmail(email);
            customer.setName(username);
            customer.setPassword(securityConfig.passwordEncoder().encode(password));
            customer.setPhoneNumber(phoneNumber);
            customer.setRole(Role.CUSTOMER);
            customerRepository.save(customer);
            return customerTransform.toModel(customer);
        } else {
            throw new RuntimeException("Customer already exists");
        }
    }

    @Override
    public String authenticateCustomer(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        if (!securityConfig.passwordEncoder().matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        return jwtUtil.generateToken(email, user.getRole());
    }
}
