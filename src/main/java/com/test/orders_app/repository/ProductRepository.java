package com.test.orders_app.repository;

import com.test.orders_app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT p.id, p.name, p.description, p.current_stock, p.price FROM products AS p INNER JOIN orders AS o ON p.id = o.product_id WHERE o.id = :orderId", nativeQuery = true)
    List<Product> findByOrderId(@Param("orderId") Integer orderId);
}
