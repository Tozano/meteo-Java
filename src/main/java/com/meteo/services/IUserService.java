package com.meteo.services;

import com.meteo.models.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();

    User getUser(int idUser);

    User getUserByUsername(String username);

    User insertUser(User user);
}
