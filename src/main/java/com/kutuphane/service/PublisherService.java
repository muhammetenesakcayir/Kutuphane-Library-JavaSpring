package com.kutuphane.service;

import com.kutuphane.model.Publisher;
import com.kutuphane.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> listAll() {
        return publisherRepository.findAll();
    }

    public void save(Publisher publisher) {
        publisherRepository.save(publisher);
    }

    public Publisher get(long id) {
        return publisherRepository.findById(id).get();
    }

    public void delete(Long publisherId) {
        publisherRepository.deleteById(publisherId);
    }
}
