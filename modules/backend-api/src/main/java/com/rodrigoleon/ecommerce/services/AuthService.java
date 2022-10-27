package com.rodrigoleon.ecommerce.services;

import com.rodrigoleon.ecommerce.dtos.auth.AuthRegisterDTO;
import com.rodrigoleon.ecommerce.model.User;
import com.rodrigoleon.ecommerce.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User createNewUser(AuthRegisterDTO registerDTO) {
        User user = new User();
        user.setEmail(registerDTO.getEmail());
        user.setName(registerDTO.getName());
        user.setPassword(this.bCryptPasswordEncoder.encode(registerDTO.getPassword()));

        return this.userRepository.save(user);
    }
}
