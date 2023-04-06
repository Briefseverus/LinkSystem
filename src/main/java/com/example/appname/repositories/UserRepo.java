package com.example.appname.repositories;

import com.example.appname.models.User;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    // Find user by id
    Optional<User> findById(int id);

    // Find user by name
    User findByName(String name);

    // Delete user by id
    void deleteById(int id);

    // Check if user exists by id
    boolean existsById(int id);
}
