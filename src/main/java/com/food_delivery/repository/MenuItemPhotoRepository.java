package com.food_delivery.repository;

import com.food_delivery.model.MenuItemPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemPhotoRepository extends JpaRepository<MenuItemPhoto, Long> {
}
