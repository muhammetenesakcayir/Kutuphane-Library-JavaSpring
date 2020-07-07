package com.kutuphane.service;

import com.kutuphane.model.Book;
import com.kutuphane.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

   private final BookRepository bookRepository;

    public SearchService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> searchBookName(String ara) {
        List<Book> books = bookRepository.findByBookName(ara);
        return books;
    }

    public List<Book> searchBookSerailName(String ara) {
        List<Book> books = bookRepository.findByBookSerialName(ara);
        return books;
    }

    public List<Book> searchAuthorName(String ara) {
        List<Book> books = bookRepository.findByAuthor_AuthorName(ara);
        return books;
    }

    public List<Book> searchIsbn(String ara) {
        List<Book> books = bookRepository.findByIsbnNo(ara);
        return books;
    }
}
