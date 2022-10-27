package com.rodrigoleon.ecommerce.dtos.auth;

import lombok.Getter;

@Getter
public class AuthRegisterDTO {
    private String email;
    private String name;
    private String password;
}
