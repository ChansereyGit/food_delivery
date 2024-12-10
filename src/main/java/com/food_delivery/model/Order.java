package com.food_delivery.model;

import com.food_delivery.enumuration.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate = new Date();
    private double totalAmount;
    private double deliverFee;
    private double tax;
    private double restaurantRating;
    private double deliveryRating;
    private OrderStatus orderStatus;
    private Long userId;
    private Long restaurantId;
    private Long deliveryId;
    private Long deliveryPartnerId;
    private Long paymentId;

}
