package com.food_delivery.model;

import com.food_delivery.enumuration.VehicleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "tbl_delivery_partner")
public class DeliveryPartner extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @Column(name = "username", unique  = true, nullable = false)
    private String username;
    private String password;
    private String gender;
    private Date dateOfBirth;
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;
    private String email;
    private String address;
    private VehicleType vehicleType;
    private boolean available;

}
