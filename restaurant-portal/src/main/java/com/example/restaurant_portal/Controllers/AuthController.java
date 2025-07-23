package com.example.restaurant_portal.Controllers;

import com.example.restaurant_portal.User.CustomUserDetailsService;
import com.example.restaurant_portal.Utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    static class AuthRequest {
        public String username;
        public String password;
    }

    static class AuthResponse {
        public String token;
        public AuthResponse(String token) {
            this.token = token;
        }
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username, request.password)
        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.username);
        String token = jwtUtil.generateToken(userDetails);
        return new AuthResponse(token);
    }
}

