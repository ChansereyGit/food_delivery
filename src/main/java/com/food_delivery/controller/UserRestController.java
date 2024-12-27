package com.food_delivery.controller;

import com.food_delivery.dto.UserRequest;
import com.food_delivery.dto.UserResponse;
import com.food_delivery.exception.ApiExceptionError;
import com.food_delivery.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserRestController {

    @Autowired
    private final UserService userService;

    @PostMapping(value = "/v1/users", consumes = "application/json", produces = "application/json")
    private ResponseEntity<Object> create(@RequestBody UserRequest userRequest){
        try{
            log.info("Intercepting request creation new user v1 with request: {} ", userRequest);
            userService.create(userRequest);
            return ResponseEntity.ok().build();
        }
        catch(IllegalArgumentException e){
            log.error("Error while creating new user: {}", e);
            var apiErrorException = ApiExceptionError.builder()
                    .errorCode("400")
                    .message(e.getLocalizedMessage())
                    .responseData(new Object())
                    .statusCode("400")
                    .build();
            return ResponseEntity.ok(apiErrorException);
        }
    }

    @PutMapping(value = "/v1/users/{id}", consumes = "application/json", produces = "application/json")
    private ResponseEntity<UserResponse> update(@RequestBody UserRequest userRequest, @PathVariable Long id){
        log.info("update request user id {} ", id);
        userService.update(id, userRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/v1/users/{id}", produces = "application/json")
    private ResponseEntity<UserResponse> findByID(@PathVariable Long id){
        log.info("Intercepting request find new user by id v1 with id: {} ", id);
       UserResponse userResponse = userService.findById(id);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping(value = "/v1/users", produces = "application/json")
    private ResponseEntity<List<UserResponse>> findAll(){
        log.info("Intercepting request find all users");
        List<UserResponse> userResponses = userService.findAll();
        return ResponseEntity.ok(userResponses);
    }

    @DeleteMapping(value = "/v1/users/{id}", produces = "application/json")
    private ResponseEntity<Void> delete(@PathVariable Long id){
        log.info("Intercepting request delete new user by id v1 with id: {} ", id);
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
