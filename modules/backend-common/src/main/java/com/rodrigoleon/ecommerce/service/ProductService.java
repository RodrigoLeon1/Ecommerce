package com.rodrigoleon.ecommerce.service;

import com.rodrigoleon.ecommerce.dtos.ProductDTO;
import com.rodrigoleon.ecommerce.exceptions.EntityNotFound;
import com.rodrigoleon.ecommerce.model.Product;
import com.rodrigoleon.ecommerce.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createNewProduct(ProductDTO newProductDTO) {
        Product newProduct = ProductDTO.of(newProductDTO);
        return this.productRepository.save(newProduct);
    }

    public Product updateProduct(String externalId, ProductDTO updatedProductDTO) {
        Product product = this.findProductByExternalId(externalId);

        product.setTitle(updatedProductDTO.getTitle());
        product.setDescription(updatedProductDTO.getDescription());
        product.setPrice(updatedProductDTO.getPrice());
        product.setCryptoCurrency(updatedProductDTO.getCryptoCurrency());
        product.setUpdatedAt(Instant.now());

        return this.productRepository.save(product);
    }

    public Page<Product> findAllPaginated(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return this.productRepository.findByDisabledAtIsNull(pageRequest);
    }

    public Product findProductByExternalId(String externalId) {
        return this.productRepository
                .findByExternalId(externalId)
                .orElseThrow(() -> new EntityNotFound(String.format("The product with externalId %s was not found.", externalId)));
    }

    public void softDeleteProductByExternalId(String externalId) {
        Product product = this.findProductByExternalId(externalId);
        product.disable();

        this.productRepository.save(product);
    }

    public void activeProductByExternalId(String externalId) {
        Product product = this.findProductByExternalId(externalId);
        product.active();

        this.productRepository.save(product);
    }
}
