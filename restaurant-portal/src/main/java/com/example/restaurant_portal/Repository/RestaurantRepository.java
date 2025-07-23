package com.example.restaurant_portal.Repository;

import com.example.restaurant_portal.Restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCityIgnoreCase(String city);
}

