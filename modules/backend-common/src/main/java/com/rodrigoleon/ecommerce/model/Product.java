package com.rodrigoleon.ecommerce.model;

import com.rodrigoleon.ecommerce.model.types.CryptoCurrencyType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private float price;

    @Enumerated(EnumType.STRING)
    private CryptoCurrencyType cryptoCurrency;
}
