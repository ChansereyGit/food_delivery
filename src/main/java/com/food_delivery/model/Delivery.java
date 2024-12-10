package com.food_delivery.model;

import com.food_delivery.enumuration.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "tbl_delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIME)
    private Date pickupTime = new Date();

    @Temporal(TemporalType.TIME)
    private Date deliveryTime = new Date();
    private String pickupAddress;
    private String deliveryAddress;
    private Double deliveryFee;
    private DeliveryStatus deliveryStatus;
    private Long partnerId;
    private Long orderId;

}
