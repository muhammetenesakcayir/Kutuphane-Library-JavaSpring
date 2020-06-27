package com.kutuphane.service;

import com.kutuphane.model.Book;
import com.kutuphane.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book get(long id) {
        return bookRepository.findById(id).get();
    }

    public void delete(long bookId) {
        bookRepository.deleteById(bookId);
    }

}
