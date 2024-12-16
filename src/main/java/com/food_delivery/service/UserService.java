package com.food_delivery.service;

import com.food_delivery.dto.UserRequest;
import com.food_delivery.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserResponse create(UserRequest userRequest);
    UserResponse findById(Long id, UserRequest userRequest);
    UserResponse update(Long id, UserRequest userRequest);
    void deleteById(Long id);
    List<UserResponse> findAll();
}
