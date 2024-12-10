package com.food_delivery.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbl_menu_item_photo")
public class MenuItemPhoto extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileType;
    private String fileName;
    private Double fileSize;
    private String fileFormat;
    private String smallUrl;
    private String mediumUrl;
    private String largeUrl;
    private String uploadBy;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private MenuItem menuItem;
}
