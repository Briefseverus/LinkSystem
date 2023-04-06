package com.example.appname.repositories;

import com.example.appname.models.Link;
import org.springframework.data.repository.CrudRepository;

public interface LinkRepo extends CrudRepository<Link, Integer> {
    Iterable<Link> findAllByUserId(int userId);
}
