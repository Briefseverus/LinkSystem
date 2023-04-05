package com.example.appname.services;

import com.example.appname.models.Link;
import com.example.appname.repositories.LinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    @Autowired
    private LinkRepo linkRepository;

    public Link saveLink(Link link) {
        return linkRepository.save(link);
    }

    public Link findLinkById(int id) {
        return linkRepository.findById(id).orElse(null);
    }

    public Iterable<Link> findAllLinks() {
        return linkRepository.findAll();
    }

    public void deleteLink(int id) {
        linkRepository.deleteById(id);
    }
}
