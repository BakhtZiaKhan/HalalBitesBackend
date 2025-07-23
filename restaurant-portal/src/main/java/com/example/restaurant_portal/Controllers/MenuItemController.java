package com.example.restaurant_portal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.restaurant_portal.Menu.MenuItem;
import com.example.restaurant_portal.Repository.MenuItemRepository;



@RestController
@RequestMapping("/api/menu-items")
@CrossOrigin(origins = "http://localhost:3000")
public class MenuItemController {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @PostMapping
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<MenuItem> getMenuItemsByRestaurant(@PathVariable Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }
}

