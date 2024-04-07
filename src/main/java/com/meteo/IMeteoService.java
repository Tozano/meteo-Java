package com.meteo;

import com.meteo.models.User;

import java.util.List;

public interface IMeteoService {
    void getAndShowAllUsersWithSelections();

    List<User> getAllUsers();
}
