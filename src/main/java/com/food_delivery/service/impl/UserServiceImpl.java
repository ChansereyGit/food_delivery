package com.food_delivery.service.impl;

import com.food_delivery.dto.UserRequest;
import com.food_delivery.dto.UserResponse;
import com.food_delivery.model.Device;
import com.food_delivery.model.User;
import com.food_delivery.repository.DeviceRepository;
import com.food_delivery.repository.UserRepository;
import com.food_delivery.service.handler.UserHandlerService;
import com.food_delivery.service.UserService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private UserHandlerService userHandlerService;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public UserResponse create(UserRequest userRequest) {
        userHandlerService.userNameHasText(userRequest.getUsername());
        userHandlerService.phoneNumberHasText(userRequest.getPhoneNumber());

        User user = userHandlerService.convertUserRequestToUser(userRequest);
        user.setDateOfBirth(userHandlerService.convertStringToDate(userRequest.getDateOfBirth()));
        log.info("User created", user);
        userRepository.saveAndFlush(user);

        if (user.getId() != null) {
            Device device = userHandlerService.convertDeviceRequestToUserDevice(user, userRequest.getDeviceRequest());
            log.info("Device created", device);
            deviceRepository.save(device);
        }
        return null;
    }

    @Override
    public UserResponse findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            log.info("User with id {} not found in db", id);
            return new UserResponse();
        }
        return userHandlerService.convertUserToUserResponse(user.get());
    }

    @Transactional
    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            log.info("User with id {} request update info, but not found in db", id);
            this.create(userRequest);
        }
        User userUpdate = user.get();
        userUpdate.setUsername(userRequest.getUsername());
        userUpdate.setFirstName(userRequest.getFirstName());
        userUpdate.setLastName(userRequest.getLastName());
        userUpdate.setPhoneNumber(userRequest.getPhoneNumber());
        userUpdate.setDateOfBirth(userHandlerService.convertStringToDate(userRequest.getDateOfBirth()));
        userUpdate.setEmail(userRequest.getEmail());
        userUpdate.setAddress(userRequest.getAddress());
        userUpdate.setUserType(userRequest.getUserType());
        userUpdate.setGender(userRequest.getGender());
        userRepository.saveAndFlush(userUpdate);

        if(userUpdate.getDevices() != null){
            var deviceRequest = userRequest.getDeviceRequest();
            if(StringUtils.hasText(deviceRequest.getDeviceId())){
                List<Device> devices = userUpdate.getDevices();
                Device deviceUpdate = devices.stream()
                        .filter(device ->
                                device.getDeviceId().equalsIgnoreCase(deviceRequest.getDeviceId()))
                       .findAny()
                        .orElse(null);
                if(deviceUpdate != null){
                    deviceUpdate.setDeviceId(deviceRequest.getDeviceId());
                    deviceUpdate.setDeviceType(deviceRequest.getDeviceType());
                    deviceUpdate.setDeviceModel(deviceRequest.getDeviceModel());
                    deviceUpdate.setOsVersion(deviceRequest.getOsVersion());
                    deviceUpdate.setAppVersion(deviceRequest.getAppVersion());
                    deviceUpdate.setTrustDevice(deviceRequest.isTrustDevice());
                    log.info("update device record {}", deviceUpdate);
                    deviceRepository.save(deviceUpdate);
                }
                else {
                    Device device = userHandlerService.convertDeviceRequestToUserDevice(userUpdate, deviceRequest);
                    deviceRepository.save(device);
                }
            }
        }
        return userHandlerService.convertUserToUserResponse(userUpdate);

    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();

        List<UserResponse> userResponses = new ArrayList<>();
        for(User user : users) {
            UserResponse userResponse = userHandlerService.convertUserToUserResponse(user);
            userResponses.add(userResponse);
        }
        return userResponses;
    }
}
