package com.meteo;

import com.meteo.models.Selection;
import com.meteo.models.User;
import com.meteo.repositories.SelectionRepository;
import com.meteo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeteoService implements IMeteoService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SelectionRepository selectionRepository;

// To test connection
    @Override
    public void getAndShowAllUsersWithSelections() {
        List<User> users = getAllUsers();
        for (User user : users) {
            System.out.println(user.getUsername());
            List<Selection>userSelections = selectionRepository.findAllByUser(user);
            for (Selection selection : userSelections) {
                System.out.println(selection.getLocationSurname());
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
