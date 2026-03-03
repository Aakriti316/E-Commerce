package com.microservices.OrderService.service;

import com.microservices.OrderService.entity.Order;
import com.microservices.OrderService.external.client.ProductService;
import com.microservices.OrderService.model.OrderRequest;
import com.microservices.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;

    @Override
    public long placeOrder(OrderRequest orderRequest) {
        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
        log.info("creating order with order status CREATED");
        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();
        orderRepository.save(order);

        log.info("order placed successfully with the id {}", order.getId());
        return order.getId();
    }
}
