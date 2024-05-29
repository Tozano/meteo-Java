package com.meteo.controllers;

import com.meteo.models.Selection;
import com.meteo.models.User;
import com.meteo.services.SelectionService;
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
    public SelectionService selectionService;

    @GetMapping("/getByIdUser/{idUser}")
    public List<Selection> getAllSelectionsByUser(@PathVariable int idUser) {
        return selectionService.getAllSelectionsByIdUser(idUser);
    }

    @GetMapping("/{idSelection}")
    public Selection getSelectionById(@PathVariable int idSelection) {
        return selectionService.getSelection(idSelection);
    }

    @PostMapping("")
    public Selection insertSelection(@RequestBody Selection selection) {
        return selectionService.insertSelection(selection);
    }

    @DeleteMapping("/{idSelection}")
    public void deleteSelection(@PathVariable int idSelection) {
        System.out.println("Hello, world!");
        selectionService.deleteSelection(idSelection);
    }

    @PutMapping("")
    public void putSelection(Selection selection) {
        selectionService.updateSelection(selection);
    }
}
