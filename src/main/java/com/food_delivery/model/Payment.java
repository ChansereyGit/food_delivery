package com.food_delivery.model;

import com.food_delivery.enumuration.PaymentMethod;
import com.food_delivery.enumuration.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbl_payment")
public class Payment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;
    private String description;
    private Long orderId;
}
