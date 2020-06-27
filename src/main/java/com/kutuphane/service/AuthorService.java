package com.kutuphane.service;

import com.kutuphane.model.Author;
import com.kutuphane.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    public void save(Author author) {
        authorRepository.save(author);
    }

    public Author get(long id) {
        return authorRepository.findById(id).get();
    }

    public void delete(Long authorId) {
        authorRepository.deleteById(authorId);
    }

}
