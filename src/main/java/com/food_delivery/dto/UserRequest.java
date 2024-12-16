package com.food_delivery.dto;

import com.food_delivery.enumuration.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

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

    private DeviceRequest deviceRequest;

    @Getter
    @Setter
    @ToString
    public static class DeviceRequest{
        private String deviceId;
        private String deviceType;
        private String deviceModel;
        private String osVersion;
        private String appVersion;
        private boolean trustDevice;
    }
}
