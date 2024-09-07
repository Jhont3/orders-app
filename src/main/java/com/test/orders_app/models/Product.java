package com.test.orders_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(length = 250)
    private String description;

    @Column(nullable = false, length = 50)
    private String price;

    @Column(name = "current_stock", nullable = false)
    private int currentStock;
}
