package com.example.appname.services;

import java.util.List;

import com.example.appname.models.Domain;
import com.example.appname.models.Link;
import com.example.appname.models.Role;

public interface DomainServices {
    List<Role> findAll();
    public Domain findDomainById(int id);
}
