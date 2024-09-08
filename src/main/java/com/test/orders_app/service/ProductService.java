package com.test.orders_app.service;

import com.test.orders_app.exceptions.ResourceNotFountException;
import com.test.orders_app.models.Product;
import com.test.orders_app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Integer id) throws ResourceNotFountException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFountException("The product with id " + id + " does not exist"));
    }
}
