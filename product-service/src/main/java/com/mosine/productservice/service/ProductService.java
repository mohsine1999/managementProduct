package com.mosine.productservice.service;

import com.mosine.productservice.model.Product;

import java.util.List;


public interface ProductService {
    public Product saveProduct(Product product);

    public Product getProduct(Long idProduct);

    public List<Product> getAllProduct();

    public void deleteProduct(Long idProduct);

    public Product updateProduct(Long idProduct, Product product);
}
