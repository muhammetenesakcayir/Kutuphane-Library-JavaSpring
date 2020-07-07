package com.kutuphane.controller;

import com.kutuphane.model.Book;
import com.kutuphane.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SearchController {

    private final BookRepository bookRepository;

    public SearchController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/search")
    public String getSearchauthor(Model model, String ara) {
        List<Book> bookname = bookRepository.findByBookName(ara);
        model.addAttribute("bookname", bookname);
        List<Book> authorName = bookRepository.findByAuthor_AuthorName(ara);
        model.addAttribute("authorName", authorName);
        List<Book> bookserail = bookRepository.findByBookSerialName(ara);
        model.addAttribute("bookserail", bookserail);
        List<Book> bookisbn = bookRepository.findByIsbnNo(ara);
        model.addAttribute("bookisbn", bookisbn);
        return "search/search";
    }

}
