package com.food_delivery.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeviceRequest {

        private String deviceId;
        private String deviceType;
        private String deviceModel;
        private String osVersion;
        private String appVersion;
        private boolean trustDevice;
}
