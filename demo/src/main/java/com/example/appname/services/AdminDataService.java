package com.example.appname.services;

import com.example.appname.models.AdminData;
import com.example.appname.repositories.AdminDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDataService {

    @Autowired
    private AdminDataRepo adminDataRepository;

    public AdminData saveAdminData(AdminData adminData) {
        return adminDataRepository.save(adminData);
    }

    public Iterable<AdminData> findAllAdminData() {
        return adminDataRepository.findAll();
    }

    public AdminData findAdminDataById(int id) {
        return adminDataRepository.findById(id).orElse(null);
    }

    public void deleteAdminData(int id) {
        adminDataRepository.deleteById(id);
    }
}
