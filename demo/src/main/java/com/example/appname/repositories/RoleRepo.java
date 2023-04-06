package com.example.appname.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.appname.models.Role;

public interface RoleRepo extends JpaRepository<Role,Integer> {
	 List<Role> findAll();
}
