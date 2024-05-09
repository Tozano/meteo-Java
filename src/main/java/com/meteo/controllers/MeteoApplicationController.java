package com.meteo.controllers;

import com.meteo.services.MeteoService;
import com.meteo.models.Selection;
import com.meteo.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MeteoApplicationController {
    @Autowired
    public MeteoService meteoService;

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    /*
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return meteoService.getAllUsers();
    }
     */

    @GetMapping("/selections/getByIdUser/{idUser}")
    public List<Selection> getAllSelectionsByUser(@PathVariable int idUser) {
        return meteoService.getAllSelectionsByIdUser(idUser);
    }

    @GetMapping("/users/{idUser}")
    public User getUserById(@PathVariable int idUser) {
        return meteoService.getUser(idUser);
    }

    @PostMapping("/users")
    public User insertUser(User user) {
        return meteoService.insertUser(user);
    }

    @GetMapping("/selections/{idSelection}")
    public Selection getSelectionById(@PathVariable int idSelection) {
        return meteoService.getSelection(idSelection);
    }

    @PostMapping("/selections")
    public Selection insertSelection(Selection selection) {
        return meteoService.insertSelection(selection);
    }
}
