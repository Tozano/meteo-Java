package com.meteo.services;

import com.meteo.models.User;
import com.meteo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

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
    public User getUserByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }

    @Override
    public User insertUser(User user) {
        return userRepository.save(user);
    }
}
