package com.food_delivery.service.handler;

import com.food_delivery.dto.DeviceRequest;
import com.food_delivery.dto.DeviceResponse;
import com.food_delivery.dto.UserRequest;
import com.food_delivery.dto.UserResponse;
import com.food_delivery.model.Device;
import com.food_delivery.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.food_delivery.constant.Constant.SYSTEM;
import static com.food_delivery.constant.Constant.USER_STATUS_ACTIVE;

@Service
@Slf4j
public class UserHandlerService {

    public void userNameHasText(String userName){
        if(StringUtils.hasText(userName)){
            return;
        }
        log.info("User name empty");
        throw new IllegalArgumentException("User name must not be empty");
    }

    public void phoneNumberHasText(String phoneNumber ){
        if(StringUtils.hasText(phoneNumber)){
            return;
        }
        log.info("Phone number empty");
        throw new IllegalArgumentException("Phone number must not be empty");
    }

    public Date convertStringToDate(String dateOfBirth){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            log.error("Invalid date format");
        }
        return new Date();
    }

    public UserResponse convertUserToUserResponse(final User user){
        return UserResponse.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .gender(user.getGender())
                    .dateOfBirth(user.getDateOfBirth().toString())
                    .email(user.getEmail())
                    .phoneNumber(user.getPhoneNumber())
                    .address(user.getAddress())
                    .userType(user.getUserType())
                    .status(user.getStatus())
                    .createdBy(user.getCreatedBy())
                    .createdAt(user.getCreatedAt())
                    .updatedBy(user.getUpdatedBy())
                    .updatedAt(user.getUpdatedAt())
                    .build();
    }

    public User convertUserRequestToUser(final UserRequest userRequest){
       User user = new User();
       user.setUsername(userRequest.getUsername());
       user.setFirstName(userRequest.getFirstName());
       user.setLastName(userRequest.getLastName());
       user.setGender(userRequest.getGender());
       user.setDateOfBirth(convertStringToDate(userRequest.getDateOfBirth()));
       user.setEmail(userRequest.getEmail());
       user.setPhoneNumber(userRequest.getPhoneNumber());
       user.setAddress(userRequest.getAddress());
       user.setUserType(userRequest.getUserType());
       user.setStatus(USER_STATUS_ACTIVE);
       user.setCreatedBy(SYSTEM);
       user.setCreatedAt(new Date());

       return user;
    }

    public Device convertDeviceRequestToUserDevice(final User user, final DeviceRequest deviceRequest) {
        Device device = new Device();
        device.setDeviceId(deviceRequest.getDeviceId());
        device.setDeviceType(deviceRequest.getDeviceType());
        device.setDeviceModel(deviceRequest.getDeviceModel());
        device.setOsVersion(deviceRequest.getOsVersion());
        device.setAppVersion(deviceRequest.getAppVersion());
        device.setTrustDevice(deviceRequest.isTrustDevice());
        device.setUser(user);
        return device;
    }

    public DeviceResponse convertUserDeviceToDeviceResponse(final Device device) {
        return DeviceResponse.builder()
                .id(device.getId())
                .deviceId(device.getDeviceId())
                .trustDevice(device.isTrustDevice())
                .deviceModel(device.getDeviceModel())
                .deviceType(device.getDeviceType())
                .osVersion(device.getOsVersion())
                .appVersion(device.getAppVersion())
                .lastLogin(device.getLastLogin())
                .status(device.getStatus())
                .build();
    }
}
