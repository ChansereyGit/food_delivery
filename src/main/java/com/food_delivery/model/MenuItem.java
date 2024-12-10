package com.food_delivery.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "tbl_menu_item")
public class MenuItem extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private String description;
    private Double price;
    private Integer availability;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

}
