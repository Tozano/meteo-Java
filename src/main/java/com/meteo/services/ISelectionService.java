package com.meteo.services;

import com.meteo.models.Selection;
import com.meteo.models.User;

import java.util.List;

public interface ISelectionService {
    void getAndShowAllUsersWithSelections();

    Selection getSelection(int idSelection);

    List<Selection> getAllSelectionsByIdUser(int idUser);

    Selection insertSelection(Selection selection);

    void updateSelection(Selection selection);

    void deleteSelection(int idSelection);
}
