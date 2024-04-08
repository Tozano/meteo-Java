package com.meteo;

import com.meteo.models.Selection;
import com.meteo.models.User;

import java.util.List;

public interface IMeteoService {
    void getAndShowAllUsersWithSelections();

    List<User> getAllUsers();

    User getUser(int idUser);

    Selection getSelection(int idSelection);

    List<Selection> getAllSelectionsByUser(User user);

    User insertUser(User user);

    Selection insertSelection(Selection selection);
}
