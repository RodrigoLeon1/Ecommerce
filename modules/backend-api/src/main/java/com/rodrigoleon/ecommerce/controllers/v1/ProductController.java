package com.rodrigoleon.ecommerce.controllers.v1;

import com.rodrigoleon.ecommerce.dtos.ApiResponse;
import com.rodrigoleon.ecommerce.dtos.ProductDTO;
import com.rodrigoleon.ecommerce.model.Product;
import com.rodrigoleon.ecommerce.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDTO>> createNewProduct(@RequestBody ProductDTO newProductDTO) {
        Product productCreated = this.productService.createNewProduct(newProductDTO);
        return ApiResponse.withSuccess(ProductDTO.from(productCreated));
    }

    @PutMapping(path = "/{externalId}")
    public ResponseEntity<ApiResponse<ProductDTO>> updateProductByExternalId(@PathVariable(name = "externalId") String externalId, @RequestBody ProductDTO updatedProductDTO) {
        Product productUpdated = this.productService.updateProduct(externalId, updatedProductDTO);
        return ApiResponse.withSuccess(ProductDTO.from(productUpdated));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<Product>>> getProductsPaginated(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Page<Product> products = this.productService.findAllPaginated(page, size);
        return ApiResponse.withSuccess(products);
    }

    @GetMapping(path = "/{externalId}")
    public ResponseEntity<ApiResponse<ProductDTO>> getProductByExternalId(@PathVariable(name = "externalId") String externalId) {
        Product product = this.productService.findProductByExternalId(externalId);
        return ApiResponse.withSuccess(ProductDTO.from(product));
    }

    @DeleteMapping(path = "/{externalId}")
    public ResponseEntity<ApiResponse<String>> deleteProductByExternalId(@PathVariable(name = "externalId") String externalId) {
        this.productService.softDeleteProductByExternalId(externalId);
        return ApiResponse.withSuccess("Product removed successfully.");
    }

    @PostMapping(path = "/{externalId}/active")
    public ResponseEntity<ApiResponse<String>> activeProductByExternalId(@PathVariable(name = "externalId") String externalId) {
        this.productService.activeProductByExternalId(externalId);
        return ApiResponse.withSuccess("Product active successfully.");
    }
}
