package com.example.restaurant_portal.Repository;

import com.example.restaurant_portal.Restaurant.RestaurantOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RestaurantOwnerRepository extends JpaRepository<RestaurantOwner, Long> {
    Optional<RestaurantOwner> findByEmail(String email);
}
