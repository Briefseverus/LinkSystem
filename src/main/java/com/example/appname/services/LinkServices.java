package com.example.appname.services;

import java.util.List;

import com.example.appname.models.Link;
import com.example.appname.models.Role;

public interface LinkServices {
    List<Role> findAll();
    public Link findLinkById(int id);
}
