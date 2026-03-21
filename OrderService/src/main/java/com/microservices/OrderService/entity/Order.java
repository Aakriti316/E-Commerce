package com.microservices.OrderService.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
    name = "ORDER_DETAILS",
    indexes = {
        @Index(name = "idx_product_id", columnList = "PRODUCT_ID"),
        @Index(name = "idx_order_date", columnList = "ORDER_DATE")
    }
)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Long productId;

    @Column(name = "QUANTITY", nullable = false)
    private Long quantity;

    @Column(name = "AMOUNT", nullable = false)
    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS", nullable = false)
    private OrderStatus orderStatus;

    @CreationTimestamp
    @Column(name = "ORDER_DATE", nullable = false, updatable = false)
    private Instant orderDate;
}
