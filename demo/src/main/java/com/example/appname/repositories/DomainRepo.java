package com.example.appname.repositories;

import com.example.appname.models.Domain;
import com.example.appname.models.Link;
import org.springframework.data.repository.CrudRepository;

public interface DomainRepo extends CrudRepository<Domain, Integer> {
    Iterable<Link> findAllByUserId(int userId);
}
