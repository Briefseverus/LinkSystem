package com.example.appname.services.impl;


import com.example.appname.models.Role;
import com.example.appname.models.User;
import com.example.appname.repositories.UserRepo;
import com.example.appname.services.UserServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepo userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User findUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
