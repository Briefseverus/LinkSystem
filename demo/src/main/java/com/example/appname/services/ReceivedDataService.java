package com.example.appname.services;

import com.example.appname.models.ReceivedData;
import com.example.appname.repositories.ReceivedDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceivedDataService {

    @Autowired
    private ReceivedDataRepo receivedDataRepository;

    public ReceivedData saveReceivedData(ReceivedData receivedData) {
        return receivedDataRepository.save(receivedData);
    }

    public Iterable<ReceivedData> findAllReceivedData() {
        return receivedDataRepository.findAll();
    }

    public ReceivedData findReceivedDataById(int id) {
        return receivedDataRepository.findById(id).orElse(null);
    }

    public void deleteReceivedData(int id) {
        receivedDataRepository.deleteById(id);
    }
}