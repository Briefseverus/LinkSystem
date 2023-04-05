package com.example.appname.repositories;

import com.example.appname.models.AdminData;
import com.example.appname.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDataRepo extends CrudRepository<AdminData, Integer> {
    Iterable<AdminData> findByUser(User user);
}
