package com.kutuphane.controller;

import com.kutuphane.model.Author;
import com.kutuphane.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService yazarService) {
        this.authorService = yazarService;
    }

    @RequestMapping("/author")
    public String viewAuthor(Model model) {
        List<Author> authorList = authorService.listAll();
        model.addAttribute("authorList", authorList);
        return "author/index";
    }

    @GetMapping("/saveauthor")
    public String getAuthor(@ModelAttribute("author") Author author) {
        return "author/create";
    }

    @PostMapping("/saveauthor")
    public String saveAutohr(Author author) {
        authorService.save(author);
        return "redirect:/author";
    }

    @GetMapping("/updateauthor/{id}")
    public String updateAuthor(@PathVariable("id") Long id , Model model) {
        Author author = authorService.get(id);
        model.addAttribute("author", author);
        return "author/edit";
    }

    @GetMapping("/deleteauthor/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorService.delete(id);
        return "redirect:/author";
    }

    @GetMapping(value = "/detailauthor/{id}")
    public String detailAuthor(@PathVariable("id") Long id, Model model) {
        Author author = authorService.get(id);
        model.addAttribute("author", author);
        return "author/detail";
    }
}
