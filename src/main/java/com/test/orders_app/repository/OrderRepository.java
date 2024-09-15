package com.test.orders_app.repository;

import com.test.orders_app.models.Order;
import com.test.orders_app.models.OrderPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, OrderPK> {
    List<Order> findAllByOrderByIdDesc();
}
