package com.food_delivery.dto;

import com.food_delivery.enumuration.UserType;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {

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

    @Column(name = "device_info")
    private DeviceRequest deviceRequest;
}
