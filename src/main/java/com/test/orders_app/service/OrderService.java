package com.test.orders_app.service;

import com.test.orders_app.models.Order;
import com.test.orders_app.dto.OrderDTO;
import com.test.orders_app.models.Product;
import com.test.orders_app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    ProductService productService;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {

        Order orderToSave = orderDtoToOrder(orderDTO);

        Integer productId = orderToSave.getProduct().getId();
        Product product = productService.getProductById(productId);
        orderToSave.setProduct(product);

        Order savedOrder = orderRepository.save(orderToSave);

        return orderToOrderDto(savedOrder);
    }

    public Order orderDtoToOrder(OrderDTO orderDTO){
        Order order = new Order();
        Product product = new Product();

        product.setId(orderDTO.getProduct_id());
        order.setProduct(product);
        order.setId(orderDTO.getId());

        return order;
    }

    public OrderDTO orderToOrderDto(Order order){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setProduct_id(order.getProduct().getId());
        orderDTO.setId(order.getId());

        return orderDTO;
    }

}
