package com.meteo.controllers;

import com.meteo.services.MeteoService;
import com.meteo.models.Selection;
import com.meteo.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MeteoApplicationController {
    @Autowired
    public MeteoService meteoService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return meteoService.getAllUsers();
    }

    @GetMapping("/selections/getByIdUser/{idUser}")
    public List<Selection> getAllSelectionsByUser(@PathVariable int idUser) {
        return meteoService.getAllSelectionsByIdUser(idUser);
    }

    @GetMapping("/users/{idUser}")
    public User getUserById(@PathVariable int idUser) {
        return meteoService.getUser(idUser);
    }

    @GetMapping("/login/{username}")
    public int login(@PathVariable String username) {
        try {
            User user = meteoService.getUserByUsername(username);
            return Math.toIntExact(user.getId());
        } catch (Exception e) {
            return -1;
        }
    }

    @PostMapping("/users")
    public User insertUser(@RequestBody User user) {
        if (!Objects.equals(user.getLang(), "fr") && !Objects.equals(user.getLang(), "eng")) {
            user.setLang("fr");
        }
        return meteoService.insertUser(user);
    }

    @GetMapping("/selections/{idSelection}")
    public Selection getSelectionById(@PathVariable int idSelection) {
        return meteoService.getSelection(idSelection);
    }

    @PostMapping("/selections")
    public Selection insertSelection(@RequestBody Selection selection) {
        if (Objects.equals(selection.getUser().getUsername(), "") || Objects.equals(selection.getUser().getFirstName(), "") || Objects.equals(selection.getUser().getLastName(), "")) {
            User databaseUser = meteoService.getUser(Math.toIntExact(selection.getUser().getId()));
            selection.setUser(databaseUser);
        }
        return meteoService.insertSelection(selection);
    }

    @DeleteMapping("/selections/{idSelection}")
    public void deleteSelection(@PathVariable int idSelection) {
        System.out.println("Hello, world!");
        meteoService.deleteSelection(idSelection);
    }

    @PutMapping("/selections")
    public void putSelection(Selection selection) {
        meteoService.updateSelection(selection);
    }
}
