package com.food_delivery.model;

import com.food_delivery.enumuration.NotificationChannel;
import com.food_delivery.enumuration.NotificationType;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbl_notification")
public class Notification extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private NotificationType notificationType;
    private NotificationChannel notificationChannel;
    private boolean read;
    private Long userId;
    private Long deviceId;
}
