package com.rodrigoleon.ecommerce.dtos;

import com.rodrigoleon.ecommerce.model.Product;
import com.rodrigoleon.ecommerce.model.types.CryptoCurrencyType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String title;
    private String description;
    private float price;
    private CryptoCurrencyType cryptoCurrency;

    public static Product of(ProductDTO productDTO) {
        Product product = new Product();

        product.setTitle(productDTO.getTitle());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCryptoCurrency(productDTO.getCryptoCurrency());
        product.active();

        return product;
    }

    public static ProductDTO from(Product product) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setTitle(product.getTitle());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setCryptoCurrency(product.getCryptoCurrency());

        return productDTO;
    }
}
