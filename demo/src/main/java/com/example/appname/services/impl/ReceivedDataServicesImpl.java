package com.example.appname.services.impl;

import com.example.appname.models.ReceivedData;
import com.example.appname.models.Role;
import com.example.appname.repositories.ReceivedDataRepo;
import com.example.appname.services.ReceivedDataServices;
import com.example.appname.services.UserServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceivedDataServicesImpl implements ReceivedDataServices{

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

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}