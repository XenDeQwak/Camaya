package com.xen.camaya.servimpl;

import com.xen.camaya.entity.User;
import com.xen.camaya.model.UserModel;
import com.xen.camaya.repository.UserRepository;
import com.xen.camaya.service.UserService;
import com.xen.camaya.transformimpl.UserTransformImpl;
import com.xen.camaya.util.Role;
import com.xen.camaya.util.configs.SecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServImpl implements UserService {

    private final UserTransformImpl userTransform;
    private final SecurityConfig securityConfig;
    private final UserRepository userRepository;

    @Override
    public UserModel createUser(String email, String username, String password) {
        User user = new User();
        user.setEmail(email);
        user.setName(username);
        user.setPassword(securityConfig.passwordEncoder().encode(password));
        user.setRole(Role.CUSTOMER);
        userRepository.save(user);
        return userTransform.toModel(user);
    }

    @Override
    public UserModel authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        try {
            if (securityConfig.passwordEncoder().matches(password, user.getPassword())) {
                return userTransform.toModel(user);
            }
        } catch (Exception e) {
            throw new RuntimeException("Invalid username or password", e);
        }
        return null;
    }
}
