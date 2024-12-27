package com.food_delivery.model;

import com.food_delivery.enumuration.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_user")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)

    private String username;

    private String firstName;

    private String lastName;

    @Column(name = "gender", length = 10 )
    private String gender;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    private String address;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String status;

    @ToString.Exclude
    @OneToMany(mappedBy ="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Device>devices;
}
