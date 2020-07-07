package com.kutuphane.repository;

import com.kutuphane.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findByBookName(String searchBookName);
    public List<Book> findByBookSerialName(String searchSerialName);
    public List<Book> findByAuthor_AuthorName(String searchAuthorName);
    public List<Book> findByIsbnNo(String searchISBN);
}

