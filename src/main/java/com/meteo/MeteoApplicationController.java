package com.meteo;

import com.meteo.models.Selection;
import com.meteo.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MeteoApplicationController {
    @Autowired
    public MeteoService meteoService;

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    public List<User> getAllUsers() {
        return meteoService.getAllUsers();
    }

    public List<Selection> getAllSelectionsByUser(User user) {
        return meteoService.getAllSelectionsByUser(user);
    }

    public User getUserById(int idUser) {
        return meteoService.getUser(idUser);
    }

    public User insertUser(User user) {
        return meteoService.insertUser(user);
    }

    public Selection getSelectionById(int idSelection) {
        return meteoService.getSelection(idSelection);
    }

    public Selection insertSelection(Selection selection) {
        return meteoService.insertSelection(selection);
    }
}
