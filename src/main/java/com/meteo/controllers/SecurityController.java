package com.meteo.controllers;

import com.meteo.models.User;
import com.meteo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class SecurityController {
    @Autowired
    public UserService userService;

    @GetMapping("/login/{username}")
    public int login(@PathVariable String username) {
        try {
            User user = userService.getUserByUsername(username);
            return Math.toIntExact(user.getId());
        } catch (Exception e) {
            return -1;
        }
    }
}
