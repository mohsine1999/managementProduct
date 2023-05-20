package com.mosine.productcompositeservice.ClientFeign;


import com.mosine.productcompositeservice.models.Product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "product-service")
public interface ProductFeign {
    @GetMapping("/api/products/{idProduct}")
    public Product getProduct(@PathVariable Long idProduct);

    @PostMapping("/api/products")
    public Product saveProduct(@RequestBody Product product);

    @GetMapping("/api/products")
    public List<Product> getAllProducts();
}
