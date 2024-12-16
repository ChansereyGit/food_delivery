package com.food_delivery.service.impl;

import com.food_delivery.dto.UserRequest;
import com.food_delivery.dto.UserResponse;
import com.food_delivery.repository.DeviceRepository;
import com.food_delivery.repository.UserRepository;
import com.food_delivery.service.UserHandlerService;
import com.food_delivery.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DeviceRepository deviceRepository;
    private final UserHandlerService userHandlerService;

    public UserServiceImpl(UserRepository userRepository, DeviceRepository deviceRepository, UserHandlerService userHandlerService) {
        this.userRepository = userRepository;
        this.deviceRepository = deviceRepository;
        this.userHandlerService = userHandlerService;
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse findById(Long id, UserRequest userRequest) {
        return null;
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<UserResponse> findAll() {
        return List.of();
    }
}
