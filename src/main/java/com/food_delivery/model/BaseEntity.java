package com.food_delivery.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseEntity {
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at", insertable = true, updatable = false)
    private String createdAt;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_at", insertable = false, updatable = true)
    private String updatedAt;
}