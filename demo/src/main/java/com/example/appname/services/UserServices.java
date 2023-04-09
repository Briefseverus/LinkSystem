package com.example.appname.services;

import java.util.List;

import org.springframework.validation.Errors;

import com.example.appname.models.Role;
import com.example.appname.models.User;

public interface UserServices {
    List<Role> findAll();

	User findUserById(int id);
	public Iterable<User> findAllUsers();
	
	void save(User user);
    Boolean checkUserLogin(User user);
    void validate(Object target, Errors errors);
    Boolean checkUserStatus(User user);
}
