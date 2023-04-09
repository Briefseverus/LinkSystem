package com.example.appname.services.impl;

import com.example.appname.models.Domain;
import com.example.appname.models.Link;
import com.example.appname.repositories.DomainRepo;
import com.example.appname.repositories.LinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomainServicesImpl {

    @Autowired
    private DomainRepo DomainRepository;

    public Domain saveDomain(Domain domain) {
        return DomainRepository.save(domain);
    }
    public Domain findDomainRepositoryById(int id) {
        return DomainRepository.findById(id).orElse(null);
    }

    public Iterable<Domain> findAllLinks() {
        return DomainRepository.findAll();
    }

    public void Domain(int id) {
    	DomainRepository.deleteById(id);
    }
}
