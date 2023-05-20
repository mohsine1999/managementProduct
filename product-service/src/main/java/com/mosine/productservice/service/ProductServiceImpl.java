package com.mosine.productservice.service;

import com.mosine.productservice.model.Product;
import com.mosine.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository dao;

    @Override
    public Product saveProduct(Product product) {
        return dao.save(product);
    }

    @Override
    public Product getProduct(Long idProduct) {
        return dao.findById(idProduct).orElse(null);
    }

    @Override
    public List<Product> getAllProduct() {
        return dao.findAll();
    }

    @Override
    public void deleteProduct(Long idProduct) {
        dao.deleteById(idProduct);
    }

    @Override
    public Product updateProduct(Long idProduct, Product product) {
        Product existingProduct = dao.findById(idProduct).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setWeight(product.getWeight());
            return dao.save(existingProduct);
        } else {
            return null;
        }
    }

}
