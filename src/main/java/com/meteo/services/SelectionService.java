package com.meteo.services;

import com.meteo.models.Selection;
import com.meteo.models.User;
import com.meteo.repositories.SelectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SelectionService implements ISelectionService {
    @Autowired
    private UserService userService;
    @Autowired
    private SelectionRepository selectionRepository;

// To test connection
    @Override
    public void getAndShowAllUsersWithSelections() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user.getUsername());
            List<Selection>userSelections = selectionRepository.findAllByUser(user);
            for (Selection selection : userSelections) {
                System.out.println(selection.getLocationSurname());
            }
        }
    }

    @Override
    public Selection getSelection(int idSelection) {
        Optional<Selection> response = selectionRepository.findById(idSelection);
        return response.orElseGet(Selection::new);
    }

    @Override
    public List<Selection> getAllSelectionsByIdUser(int idUser) {
        User user = userService.getUser(idUser);
        return selectionRepository.findAllByUser(user);
    }

    @Override
    public Selection insertSelection(Selection selection) {
        if (Objects.equals(selection.getUser().getUsername(), "") || Objects.equals(selection.getUser().getFirstName(), "") || Objects.equals(selection.getUser().getLastName(), "")) {
            User databaseUser = userService.getUser(Math.toIntExact(selection.getUser().getId()));
            selection.setUser(databaseUser);
        }
        return selectionRepository.save(selection);
    }

    @Override
    public void updateSelection(Selection selection) {
        Selection selectionInDatabase = this.getSelection(Math.toIntExact(selection.getId()));
        selectionInDatabase = selection;
        selectionRepository.save(selectionInDatabase);
    }

    @Override
    public void deleteSelection(int idSelection) {
        selectionRepository.deleteById(idSelection);
    }
}
