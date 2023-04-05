package com.example.appname.services;

import java.util.List;

import com.example.appname.models.Role;
import com.example.appname.models.User;

public interface UserServices {
    List<Role> findAll();

	User findUserById(int id);
	public Iterable<User> findAllUsers();
}
