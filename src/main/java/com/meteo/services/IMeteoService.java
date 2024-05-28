package com.meteo.services;

import com.meteo.models.Selection;
import com.meteo.models.User;

import java.util.List;

public interface IMeteoService {
    void getAndShowAllUsersWithSelections();

    List<User> getAllUsers();

    User getUser(int idUser);

    User getUserByUsername(String username);

    Selection getSelection(int idSelection);

    List<Selection> getAllSelectionsByIdUser(int idUser);

    User insertUser(User user);

    Selection insertSelection(Selection selection);

    void updateSelection(Selection selection);

    void deleteSelection(int idSelection);
}
