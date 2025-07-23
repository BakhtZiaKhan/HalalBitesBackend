package com.example.restaurant_portal.Restaurant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String cuisine;
    private boolean halal;
    private boolean vegan;
    private boolean vegetarian;

    // Getters and setters
}
