package com.meteo.controllers;

import com.meteo.models.User;
import com.meteo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{idUser}")
    public User getUserById(@PathVariable int idUser) {
        return userService.getUser(idUser);
    }

    @PostMapping("")
    public User insertUser(@RequestBody User user) {
        if (!Objects.equals(user.getLang(), "fr") && !Objects.equals(user.getLang(), "eng")) {
            user.setLang("fr");
        }
        return userService.insertUser(user);
    }
}
