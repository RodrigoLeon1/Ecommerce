package com.rodrigoleon.ecommerce.service;

import com.rodrigoleon.ecommerce.dtos.ProductDTO;
import com.rodrigoleon.ecommerce.model.Product;
import com.rodrigoleon.ecommerce.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createNewProduct(ProductDTO newProductDTO) {
        return this.productRepository.save(ProductDTO.of(newProductDTO));
    }

    public Page<Product> findAllPaginated(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return this.productRepository.findAll(pageRequest);
    }
}
