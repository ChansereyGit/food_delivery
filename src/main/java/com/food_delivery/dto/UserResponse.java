package com.food_delivery.dto;

import com.food_delivery.enumuration.UserType;
import com.food_delivery.model.BaseEntity;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserResponse {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String gender;

    private String dateOfBirth;

    private String email;

    private String phoneNumber;

    private String address;

    private UserType userType;

    private String status;

    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at", insertable = true, updatable = false)
    private Date createdAt;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_at", insertable = false, updatable = true)
    private String updatedAt;
}
