package com.rodrigoleon.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Getter
@Setter
@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant disabledAt;
}
