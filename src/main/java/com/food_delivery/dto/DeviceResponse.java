package com.food_delivery.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceResponse {
        private Long id;
        private String deviceId;
        private String deviceType;
        private String deviceModel;
        private String osVersion;
        private String appVersion;
        private boolean trustDevice;
        private Date lastLogin;
        private String status;
}
