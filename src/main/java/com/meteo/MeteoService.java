package com.meteo;

import com.meteo.models.User;
import com.meteo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeteoService implements IMeteoService {
    @Autowired
    private UserRepository userRepository;

// To test connection
    @Override
    public void getAndShowAllUser() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }
}
