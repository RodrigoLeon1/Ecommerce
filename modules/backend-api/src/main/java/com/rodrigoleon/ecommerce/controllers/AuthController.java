package com.rodrigoleon.ecommerce.controllers;

import com.rodrigoleon.ecommerce.dtos.ApiResponse;
import com.rodrigoleon.ecommerce.dtos.UserDTO;
import com.rodrigoleon.ecommerce.dtos.auth.AuthRegisterDTO;
import com.rodrigoleon.ecommerce.model.User;
import com.rodrigoleon.ecommerce.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserDTO>> registerNewUser(@RequestBody AuthRegisterDTO authRegisterDTO) {
        User userCreated = this.authService.createNewUser(authRegisterDTO);
        return ApiResponse.withSuccess(UserDTO.from(userCreated));
    }

}
