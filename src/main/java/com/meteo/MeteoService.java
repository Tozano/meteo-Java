package com.meteo;

import com.meteo.models.Selection;
import com.meteo.models.User;
import com.meteo.repositories.SelectionRepository;
import com.meteo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
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
        return userRepository.findAll();
    }

    @Override
    public User getUser(int idUser) {
        Optional<User> response = userRepository.findById(idUser);
        return response.orElseGet(User::new);
    }

    @Override
    public Selection getSelection(int idSelection) {
        Optional<Selection> response = selectionRepository.findById(idSelection);
        return response.orElseGet(Selection::new);
    }

    @Override
    public List<Selection> getAllSelectionsByUser(User user) {
        return selectionRepository.findAllByUser(user);
    }

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Selection insertSelection(Selection selection) {
        return selectionRepository.save(selection);
    }
}
