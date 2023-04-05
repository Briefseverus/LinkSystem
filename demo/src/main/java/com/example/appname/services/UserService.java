package com.example.appname.services;

import com.example.appname.models.User;
import com.example.appname.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
