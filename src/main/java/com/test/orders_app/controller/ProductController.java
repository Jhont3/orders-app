package com.test.orders_app.controller;

import com.test.orders_app.exceptions.ResourceNotFountException;
import com.test.orders_app.models.Product;
import com.test.orders_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> productSearch(@PathVariable("id") Integer id) throws ResourceNotFountException {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/order")
    public ResponseEntity<List<Product>> listProducts(@RequestParam Integer orderId) throws ResourceNotFountException {
        List<Product> products = productService.getProductsByOrderId(orderId);
        return ResponseEntity.ok(products);
    }

}
