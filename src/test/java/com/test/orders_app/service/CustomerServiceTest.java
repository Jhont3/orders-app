package com.test.orders_app.service;

import com.test.orders_app.models.Product;
import com.test.orders_app.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void whenGetAllProducts_thenReturnAllProducts() {

        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("Description for Test Product");
        product.setPrice("10.99");
        product.setCurrentStock(2);

        List<Product> products = new ArrayList<>();
        products.add(product);

        when(productService.getProducts()).thenReturn(products);

        List<Product> response = productService.getProducts();

        Assert.notNull(response, "response should not be null");
    }

}
