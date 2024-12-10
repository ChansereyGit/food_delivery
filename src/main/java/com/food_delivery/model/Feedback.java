package com.food_delivery.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "tbl_feedback")
public class Feedback extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "comment", length = 200)
    private String comment;

    private Double rating;
    private Date feedbackDate;
    private Long restaurantId;
    private Long orderId;
    private Long userId;
    private Long deliveryId;
}
