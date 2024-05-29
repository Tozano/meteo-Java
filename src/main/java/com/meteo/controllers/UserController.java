package com.meteo.controllers;

import com.meteo.services.MeteoService;
import com.meteo.models.User;
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
    public MeteoService meteoService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return meteoService.getAllUsers();
    }

    @GetMapping("/{idUser}")
    public User getUserById(@PathVariable int idUser) {
        return meteoService.getUser(idUser);
    }

    @PostMapping("")
    public User insertUser(@RequestBody User user) {
        if (!Objects.equals(user.getLang(), "fr") && !Objects.equals(user.getLang(), "eng")) {
            user.setLang("fr");
        }
        return meteoService.insertUser(user);
    }
}
