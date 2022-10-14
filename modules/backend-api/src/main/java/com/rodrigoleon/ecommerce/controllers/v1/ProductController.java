package com.rodrigoleon.ecommerce.controllers.v1;

import com.rodrigoleon.ecommerce.dtos.ApiResponse;
import com.rodrigoleon.ecommerce.dtos.ProductDTO;
import com.rodrigoleon.ecommerce.model.Product;
import com.rodrigoleon.ecommerce.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<Product>>> getProductsPaginated(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        return ApiResponse.withSuccess(this.productService.findAllPaginated(page, size));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDTO>> postNewProduct(@RequestBody ProductDTO newProductDTO) {
        Product productCreated = this.productService.createNewProduct(newProductDTO);
        return ApiResponse.withSuccess(ProductDTO.from(productCreated));
    }
}
