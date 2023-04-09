package com.example.appname.services.impl;

import com.example.appname.models.Role;
import com.example.appname.models.User;
import com.example.appname.repositories.UserRepo;
import com.example.appname.services.UserServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepo userRepository;
	@Lazy
	private PasswordEncoder passwordEncoder;

	@Override
	public void save(User user) {
		user.setPass(passwordEncoder.encode(user.getPass()));
	}

	@Override
	public Boolean checkUserLogin(User user) {
		Optional<User> userFound = Optional.ofNullable(userRepository.findByName(user.getName()));
		return userFound.map(value -> value.getPass().equals(user.getPass())).orElse(false);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (user.getPass().length() < 6) {
			errors.rejectValue("password", "errorMin");
		}
		if (user.getPass().length() > 12) {
			errors.rejectValue("password", "errorMax");
		}
	}

	@Override
	public User findUserById(int id) {
		Optional<User> userOptional = userRepository.findById(id);
		return userOptional.orElse(null);
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

	@Override
	public Boolean checkUserStatus(User user) {
		// TODO Auto-generated method stub
		return user.is_activated();
	}
}
