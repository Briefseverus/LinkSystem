package com.example.appname.repositories;

import com.example.appname.models.ReceivedData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivedDataRepo extends CrudRepository<ReceivedData, Integer> {
    Iterable<ReceivedData> findAllByUser_Id(int userId);
}
