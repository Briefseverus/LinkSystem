package com.example.appname.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appname.models.Role;
import com.example.appname.repositories.RoleRepo;
import com.example.appname.services.RoleServices;

@Service
public class RoleServicesImpl implements RoleServices {
    @Autowired
    RoleRepo roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
