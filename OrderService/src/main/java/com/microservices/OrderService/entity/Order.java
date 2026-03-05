package com.microservices.OrderService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.Instant;

@Entity
@Log4j2
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ORDER_DETAILS")
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "ORDER_STATUS")
    private String orderStatus;

    @Column(name = "ORDER_DATE")
    private Instant orderDate ;
}
