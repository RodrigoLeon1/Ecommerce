package com.rodrigoleon.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User extends Audit {
    @Id @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private String name;
}
