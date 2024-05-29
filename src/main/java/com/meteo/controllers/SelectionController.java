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
@RequestMapping("/api/selections")
@CrossOrigin(origins = "http://localhost:4200")
public class SelectionController {
    @Autowired
    public MeteoService meteoService;

    @GetMapping("/getByIdUser/{idUser}")
    public List<Selection> getAllSelectionsByUser(@PathVariable int idUser) {
        return meteoService.getAllSelectionsByIdUser(idUser);
    }

    @GetMapping("/{idSelection}")
    public Selection getSelectionById(@PathVariable int idSelection) {
        return meteoService.getSelection(idSelection);
    }

    @PostMapping("")
    public Selection insertSelection(@RequestBody Selection selection) {
        if (Objects.equals(selection.getUser().getUsername(), "") || Objects.equals(selection.getUser().getFirstName(), "") || Objects.equals(selection.getUser().getLastName(), "")) {
            User databaseUser = meteoService.getUser(Math.toIntExact(selection.getUser().getId()));
            selection.setUser(databaseUser);
        }
        return meteoService.insertSelection(selection);
    }

    @DeleteMapping("/{idSelection}")
    public void deleteSelection(@PathVariable int idSelection) {
        System.out.println("Hello, world!");
        meteoService.deleteSelection(idSelection);
    }

    @PutMapping("")
    public void putSelection(Selection selection) {
        meteoService.updateSelection(selection);
    }
}
