package com.mosine.productservice.controller;
import com.mosine.productservice.model.Product;
import com.mosine.productservice.service.ProductService;
import com.mosine.productservice.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@RefreshScope
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Product> getProduct(@PathVariable Long idProduct) {
        Product product = productService.getProduct(idProduct);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long idProduct) {
        productService.deleteProduct(idProduct);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long idProduct, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(idProduct, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

