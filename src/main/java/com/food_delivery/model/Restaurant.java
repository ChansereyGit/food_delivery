package com.food_delivery.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "tbl_restaurant")
public class Restaurant extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private String category;
    private String address;
    private String description;
    private Double rating;
    private String phoneNumber;
    private String logoUrl;
    @Temporal(TemporalType.TIME)
    private Date openTime;
    @Temporal(TemporalType.TIME)
    private Date closeTime;
}
